/*
 * Copyright (c) Joachim Ansorg, mail@ansorg-it.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.documentation;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.io.StreamUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Base class for documentation source implementations
 * which load data from the classpath.
 * <br>
 * @author jansorg
 */
abstract class ClasspathDocSource implements DocumentationSource {
    private static final Logger log = Logger.getInstance("#bash.DocumentationReader");
    private final String prefixPath;

    ClasspathDocSource(String prefixPath) {
        this.prefixPath = prefixPath;
    }

    public String documentation(PsiElement element, PsiElement originalElement) {
        if (!isValid(element, originalElement)) {
            return null;
        }

        return readFromClasspath(prefixPath, resourceNameForElement(element));
    }

    abstract String resourceNameForElement(PsiElement element);

    abstract boolean isValid(PsiElement element, PsiElement originalElement);

    /**
     * Reads documenation from a url, mostly this is a file source.
     *
     * @param path    The prefix path to use.
     * @param command The command name, e.g. "echo"
     * @return The documentation content or null.
     */
    private String readFromClasspath(String path, String command) {
        if (StringUtil.isEmpty(path) || StringUtil.isEmpty(command)) {
            return null;
        }

        final String fullPath = path + "/" + command + ".html";
        try {
            URL url = getClass().getResource(fullPath);
            if (url == null) {
                return null;
            }

            final InputStream inputStream = new BufferedInputStream(url.openStream());

            return StreamUtil.readText(inputStream, "UTF-8");
        } catch (IOException e) {
            log.debug("Failed to read documentation.", e);
        }

        return null;
    }
}

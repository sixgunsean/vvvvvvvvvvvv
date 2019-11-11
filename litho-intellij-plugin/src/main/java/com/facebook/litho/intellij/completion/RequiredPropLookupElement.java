/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.litho.intellij.completion;

import com.facebook.litho.intellij.extensions.EventLogger;
import com.facebook.litho.intellij.logging.LithoLoggerProvider;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementDecorator;
import com.intellij.codeInsight.lookup.LookupElementPresentation;

/**
 * Emphasizes the lookup element passed as a delegate by adding underline and "required Prop" text.
 */
class RequiredPropLookupElement extends LookupElementDecorator<LookupElement> {

  static RequiredPropLookupElement create(LookupElement delegate) {
    return new RequiredPropLookupElement(delegate);
  }

  private RequiredPropLookupElement(LookupElement delegate) {
    super(delegate);
  }

  @Override
  public void renderElement(LookupElementPresentation presentation) {
    super.renderElement(presentation);
    presentation.appendTailTextItalic(" required Prop", true);
    presentation.setItemTextUnderlined(true);
  }

  @Override
  public void handleInsert(InsertionContext context) {
    super.handleInsert(context);
    LithoLoggerProvider.getEventLogger().log(EventLogger.EVENT_COMPLETION_REQUIRED_PROP);
  }
}

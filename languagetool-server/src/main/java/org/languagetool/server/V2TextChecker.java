/* LanguageTool, a natural language style checker
 * Copyright (C) 2016 Daniel Naber (http://www.danielnaber.de)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.server;

import org.languagetool.Language;
import org.languagetool.rules.RuleMatch;

import java.util.List;

/**
 * Checker for v2 of the API, which returns JSON.
 * @since 3.4
 */
class V2TextChecker extends TextChecker {
  
  V2TextChecker(HTTPServerConfig config, boolean internalServer) {
    super(config, internalServer);
  }

  @Override
  protected String getResponse(String text, Language lang, Language motherTongue, List<RuleMatch> matches) {
    RuleMatchesAsJsonSerializer serializer = new RuleMatchesAsJsonSerializer();
    return serializer.ruleMatchesToJson(matches, text, CONTEXT_SIZE, lang, motherTongue);
  }

}
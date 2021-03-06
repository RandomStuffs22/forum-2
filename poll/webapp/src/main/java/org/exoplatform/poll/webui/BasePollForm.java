/*
 * Copyright (C) 2003-2009 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.poll.webui;

import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.forum.common.webui.BaseUIForm;
import org.exoplatform.forum.common.webui.WebUIUtils;
import org.exoplatform.poll.service.PollService;
import org.exoplatform.webui.application.WebuiRequestContext;

/**
 * Base class for UIForm used in poll application. Provides convenience methods to access the service
 * 
 * @author <a href="mailto:patrice.lamarque@exoplatform.com">Patrice Lamarque</a>
 * @version $Revision$
 */
public class BasePollForm extends BaseUIForm {

  private PollService pollService;

  /**
   * Get a reference to the forum service
   * 
   * @return
   */
  protected PollService getPollService() {
    if (pollService == null) {
      pollService = (PollService) ExoContainerContext.getCurrentContainer().getComponentInstanceOfType(PollService.class);
    }
    return pollService;
  }

  /**
   * Set poll service (used by unit tests)
   * 
   * @param pollService
   */
  protected void setPollService(PollService pollService) {
    this.pollService = pollService;
  }

  public void processRender(WebuiRequestContext context) throws Exception {
    WebUIUtils.addScripts("ForumUtils", "forumUtils", "forumUtils.initTooltip('" + getId() + "');");
    super.processRender(context);
  }

}

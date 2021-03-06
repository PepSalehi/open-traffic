/**
 * Copyright 2012. The Regents of the University of California (Regents).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package edu.berkeley.path.bots.netconfig.io.files
import scala.sys.SystemProperties
import edu.berkeley.path.bots.core.MMLogging

object Files extends MMLogging {
  def dataDir() = {
    val s = new SystemProperties
    s.get("mm.data.dir") match {
      case Some(s) => s
      case _ => s.get("MM_DATA_DIR") match {
        case Some(s) => logWarning("Using environment variable ") ; s
        case None => logError("Could not find data dir") ; "/tmp/"
      }
    }
  }

  def setDataDir(s: String): Unit = {
    val sp = new SystemProperties
    sp.put("mm.data.dir", s)
  }

}
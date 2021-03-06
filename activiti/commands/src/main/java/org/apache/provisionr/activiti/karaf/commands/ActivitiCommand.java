/*
 * Copyright 2012 Cisco Systems
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.provisionr.activiti.karaf.commands;

import java.io.PrintWriter;
import org.activiti.engine.ProcessEngine;
import org.apache.karaf.shell.console.OsgiCommandSupport;

/**
 * Base class for implementing Activiti Karaf commands
 *
 * @author Srinivasan Chikkala
 */
public abstract class ActivitiCommand extends OsgiCommandSupport {

    /**
     * By default write normal messages to stdout
     */
    private PrintWriter out = new PrintWriter(System.out, true);

    /**
     * By default write error messages to stderr
     */
    private PrintWriter err = new PrintWriter(System.err, true);

    private ProcessEngine processEngine;

    public ProcessEngine getProcessEngine() {
        return processEngine;
    }

    public void setProcessEngine(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    public PrintWriter out() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public PrintWriter err() {
        return err;
    }

    public void setErr(PrintWriter err) {
        this.err = err;
    }
}

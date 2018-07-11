    package com.scg.domain;

import java.util.EventListener;

// TODO: Auto-generated Javadoc
/**
 * Interface for accepting notification of consultant terminations.
 *
 * @author Russ Moul
 */
public interface TerminationListener extends EventListener {

    /**
     * Invoked when a consultant is voluntarily terminated.
     *
     * @param evt the termination event
     */
    void voluntaryTermination(TerminationEvent evt);

    /**
     * Invoked when a consultant is involuntarily terminated.
     *
     * @param evt the termination event
     */
    void forcedTermination(TerminationEvent evt);
}

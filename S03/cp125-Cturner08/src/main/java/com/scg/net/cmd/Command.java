package com.scg.net.cmd;

import java.io.Serializable;

import com.scg.net.server.CommandProcessor;

// TODO: Auto-generated Javadoc
/**
 * The Interface Command.
 *
 * @param <T> the generic type
 */
public interface Command<T> extends Serializable {

	/**
	 * Gets the receiver.
	 *
	 * @return the receiver
	 */
	public CommandProcessor getReceiver();

	/**
	 * Sets the receiver.
	 *
	 * @param receiver the new receiver
	 */
	public void setReceiver(CommandProcessor receiver);

	/**
	 * Gets the target.
	 *
	 * @return the target
	 */
	public T getTarget();

	/**
	 * Execute.
	 */
	public void execute();



}

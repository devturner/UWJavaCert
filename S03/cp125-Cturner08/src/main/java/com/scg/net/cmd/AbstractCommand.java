package com.scg.net.cmd;

import com.scg.net.server.CommandProcessor;



// TODO: Auto-generated Javadoc
/**
 * The Class AbstractCommand.
 *
 * @param <T> the generic type
 */
public abstract class AbstractCommand<T> implements Command<T> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5192213224384057517L;
	//make private and use setters and getters
	/** The Target. */
	private T Target = null;

	/** The receiver. */
	public CommandProcessor receiver = null;


	/**
	 * Instantiates a new abstract command.
	 */
	public AbstractCommand() {
		super();
	}


	/**
	 * Instantiates a new abstract command.
	 *
	 * @param target the target
	 */
	public AbstractCommand(T target) {
		super();
		Target = target;
	}


	/* (non-Javadoc)
	 * @see com.scg.net.cmd.Command#getReceiver()
	 */
	public CommandProcessor getReceiver() {
		return receiver;
	}


	/* (non-Javadoc)
	 * @see com.scg.net.cmd.Command#setReceiver(com.scg.net.server.CommandProcessor)
	 */
	public void setReceiver(CommandProcessor receiver) {
		this.receiver = receiver;
	}


	/* (non-Javadoc)
	 * @see com.scg.net.cmd.Command#getTarget()
	 */
	public T getTarget() {
		return Target;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("AbstractCommand [Target=%s, receiver=%s]",
				Target, receiver);
	}




}

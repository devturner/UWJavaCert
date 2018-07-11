package com.scg.net.cmd;

// TODO: Auto-generated Javadoc
/**
 * The Class ShutdownCommand.
 */
public final class ShutdownCommand extends AbstractCommand<Void>{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8313475077534239083L;

	/**
	 * Instantiates a new shutdown command.
	 */
	public ShutdownCommand() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.scg.net.cmd.Command#execute()
	 */
	@Override
	public void execute() {
		getReceiver().execute(this);
    }
}

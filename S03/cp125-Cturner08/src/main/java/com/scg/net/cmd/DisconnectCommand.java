package com.scg.net.cmd;

// TODO: Auto-generated Javadoc
/**
 * The Class DisconnectCommand.
 */
public final class DisconnectCommand extends AbstractCommand<Void> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5963647271559377154L;

	/**
	 * Instantiates a new disconnect command.
	 */
	public DisconnectCommand() {
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

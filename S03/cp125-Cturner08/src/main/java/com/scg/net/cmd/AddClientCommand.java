package com.scg.net.cmd;

import com.scg.domain.ClientAccount;

// TODO: Auto-generated Javadoc
/**
 * The Class AddClientCommand.
 */
public final class AddClientCommand extends AbstractCommand<ClientAccount> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5917364448228198875L;

	/**
	 * Instantiates a new adds the client command.
	 *
	 * @param target the target
	 */
	public AddClientCommand(ClientAccount target) {
		super(target);
	}

	/* (non-Javadoc)
	 * @see com.scg.net.cmd.Command#execute()
	 */
	@Override
	public void execute() {
		getReceiver().execute(this);
    }

}

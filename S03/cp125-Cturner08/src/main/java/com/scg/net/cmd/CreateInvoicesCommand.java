package com.scg.net.cmd;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateInvoicesCommand.
 */
public final class CreateInvoicesCommand extends AbstractCommand<Date> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6465723540295466985L;

	/**
	 * Instantiates a new creates the invoices command.
	 *
	 * @param target the target
	 */
	public CreateInvoicesCommand(final Date target) {
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

package com.scg.net.cmd;

import com.scg.domain.Consultant;

// TODO: Auto-generated Javadoc
/**
 * The Class AddConsultantCommand.
 */
public final class AddConsultantCommand extends AbstractCommand<Consultant> {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1043616836812016530L;

	/**
	 * Instantiates a new adds the consultant command.
	 *
	 * @param target the target
	 */
	public AddConsultantCommand(Consultant target) {
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

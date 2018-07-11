package com.scg.net.cmd;

import com.scg.domain.TimeCard;

// TODO: Auto-generated Javadoc
/**
 * The Class AddTimeCardCommand.
 */
public final class AddTimeCardCommand extends AbstractCommand<TimeCard> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1756936222794293427L;

	/**
	 * Instantiates a new adds the time card command.
	 *
	 * @param target the target
	 */
	public AddTimeCardCommand(TimeCard target) {
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

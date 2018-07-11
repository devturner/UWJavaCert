package com.scg.net.cmd;

import com.scg.domain.TimeCard;

// TODO: Auto-generated Javadoc
/**
 * Command that adds a TimeCard to the server's list of TimeCards.
 *
 * @author Russ Moul
 */
@SuppressWarnings("serial")
public final class AddTimeCardCommand extends AbstractCommand<TimeCard> {

    /**
     * Construct an AddTimeCardCommand with a target.
     *
     * @param target the target of this Command.
     */
    public AddTimeCardCommand(final TimeCard target) {
        super(target);
    }

    /**
     * Execute this command by calling receiver.execute(this).
     */
    @Override
    public void execute() {
        getReceiver().execute(this);
    }
}

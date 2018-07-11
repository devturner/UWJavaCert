package com.scg.net.cmd;

// TODO: Auto-generated Javadoc
/**
 * The command to disconnect, this command has no target.
 *
 * @author Russ Moul
 */
@SuppressWarnings("serial")
public final class DisconnectCommand extends AbstractCommand<Void> {

    /**
     * Construct an DisconnectCommand.
     */
    public DisconnectCommand() {
        super();
    }

    /**
     * Execute this Command by calling receiver.execute(this).
     */
    @Override
    public void execute() {
        getReceiver().execute(this);
    }
}

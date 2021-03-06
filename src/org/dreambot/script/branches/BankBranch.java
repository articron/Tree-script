package org.dreambot.script.branches;

import org.dreambot.api.Node;
import org.dreambot.api.NodeBranch;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.walking.web.node.impl.bank.WebBankArea;
import org.dreambot.script.leafs.OpenBankLeaf;
import org.dreambot.script.leafs.WalkToBankLeaf;

public class BankBranch extends NodeBranch {

    private final Node bankLeaf = new OpenBankLeaf();
    private final Node walkLeaf = new WalkToBankLeaf();

    @Override
    public Node isTrue() {
        return bankLeaf;
    }

    @Override
    public Node isFalse() {
        return walkLeaf;
    }

    @Override
    public boolean validate(MethodContext context) {
        return WebBankArea.GRAND_EXCHANGE.getArea().contains(context.getLocalPlayer());
    }
}

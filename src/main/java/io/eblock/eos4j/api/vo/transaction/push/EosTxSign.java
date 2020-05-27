package io.eblock.eos4j.api.vo.transaction.push;

/**
 * EOS适配
 * @version 1.0
 * @author: liwp20979
 * @date: Created in 2020/5/27 10:43
 */
public class EosTxSign {
    public EosTxSign() {

    }

    public EosTxSign(String chain_id, EosTx transaction) {
        this.chain_id = chain_id;
        this.transaction = transaction;
    }

    private String chain_id;

    private EosTx transaction;

    public String getChain_id() {
        return chain_id;
    }

    public void setChain_id(String chain_id) {
        this.chain_id = chain_id;
    }

    public EosTx getTransaction() {
        return transaction;
    }

    public void setTransaction(EosTx transaction) {
        this.transaction = transaction;
    }
}

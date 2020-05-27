package io.eblock.eos4j.api.vo.transaction.push;

import io.eblock.eos4j.api.vo.BaseVo;

/**
 * 适配EOS
 * @version 1.0
 * @author: liwp20979
 * @date: Created in 2020/5/27 10:41
 */
public class EosTxRequest extends BaseVo {
    private EosTx transaction;
    private String[] signatures;

    public EosTxRequest() {
    }

    public EosTxRequest(EosTx transaction, String[] signatures) {
        this.transaction = transaction;
        this.signatures = signatures;
    }

    public EosTx getTransaction() {
        return this.transaction;
    }

    public void setTransaction(EosTx transaction) {
        this.transaction = transaction;
    }

    public String[] getSignatures() {
        return this.signatures;
    }

    public void setSignatures(String[] signatures) {
        this.signatures = signatures;
    }
}

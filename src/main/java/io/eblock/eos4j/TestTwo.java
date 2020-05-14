package io.eblock.eos4j;

import io.eblock.eos4j.api.vo.SignParam;
import io.eblock.eos4j.api.vo.transaction.push.Tx;
import io.eblock.eos4j.api.vo.transaction.push.TxAction;
import io.eblock.eos4j.api.vo.transaction.push.TxSign;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: liwp20979
 * @date: Created in 2020/5/14 14:58
 */
public class TestTwo {
    public static void main(String[] args) {
        Rpc rpc = new Rpc("https://fullnode.ccachain.info");
        // 获取离线签名参数
        SignParam params = rpc.getOfflineSignParams(60L);
        // 离线签名
        OfflineSign sign = new OfflineSign();
        // 交易信息
        String content = "";
        try {
            Tx tx = new Tx();
            tx.setExpiration(params.getHeadBlockTime().getTime() / 1000 + params.getExp());
            tx.setRef_block_num(params.getLastIrreversibleBlockNum());
            tx.setRef_block_prefix(params.getRefBlockPrefix());
            tx.setNet_usage_words(0L);
            tx.setMax_cpu_usage_ms(0L);
            tx.setDelay_sec(0L);
            // actions
            List<TxAction> actions = new ArrayList<>();
            tx.setActions(actions);

            Map<String, Object> upbidderbMap = new LinkedHashMap<>();
            upbidderbMap.put("user", "a12312343232");
            upbidderbMap.put("acc_name", "非屏蔽");
            upbidderbMap.put("license_hash", "1d07e733ecc29976427052224f4dbc28c186afa6f2248f0f22b8bca45b5b37d6");

            TxAction createAction = new TxAction("a12312343232", "idfiledapp", "upbidderb", upbidderbMap);
            actions.add(createAction);

            content = Ecc.signTransaction("5KSk9tKJDsLi3s94W5jYexyt76QXBFwZeZieK1YdvdXwWyXqesG", new TxSign(params.getChainId(), tx));
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

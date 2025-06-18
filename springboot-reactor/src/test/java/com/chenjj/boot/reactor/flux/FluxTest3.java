package com.chenjj.boot.reactor.flux;

import reactor.core.publisher.Flux;

/**
 * @ClassName FluxTest3
 * @Description
 * @Author chenjunjiang
 * @Date 11:29 2025/5/8
 * @Version 1.0
 **/
public class FluxTest3 {
    public static void main(String[] args) {
        /*Flux.range(1, 100).log()
                .limitRate(10) // 预取10个数据，当达到75%（四舍五入，这里就是8个）时，会再次request(8)
                .subscribe();*/

        /*Flux.range(1, 100).log()
                // 当lowTide小于highTide时，每次会request(lowTide)个数据；
                // 当lowTide大于等于highTide时，每次会request(highTide*75%)个数据
                .limitRate(20,18)
                .subscribe();*/

        Flux.range(1, 10).log()
                .take(2)// 取2次就取消，不能再取了
                .subscribe();
    }
}

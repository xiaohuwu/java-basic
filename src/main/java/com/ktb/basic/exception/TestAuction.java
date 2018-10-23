package com.ktb.basic.exception;
/**
 * Created by dell on 2018-10-22.
/**
 * 异常的处理方式
 * <1> try{}catch(Exception e){} </>
 * thorws 出去
 * try{}catch(Exception e){ throw exception e}
 * throw runtimeException 时
 */
public class TestAuction {
    private double initPrice = 30.0;
    public void bid(String bidPrice) {
        double d = 0.0;
        try{
            d = Double.parseDouble(bidPrice);
        }catch (Exception e){
            //此处完成本方法中可以对异常执行的修复处理，此处仅仅是在控制台打印异常跟踪信息。
            e.printStackTrace();
            //再次抛出自定义异常
            throw new SalException("竞拍价必须是数值，不能包含其他字符！");
        }
        initPrice = d;
    }

    public static void main(String[] args) {
        TestAuction testAuction = new TestAuction();
        try {
            testAuction.bid("we");
        } catch (SalException e) {
            e.printStackTrace();
        }
    }

}

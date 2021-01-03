package com.gfar.java.basis.tim;

public class Main {
    public static void main(String[] args) {
        TLSSigAPIv2 tlsSigAPIv2 = new TLSSigAPIv2(1400326291,"57764744649745f809d6c16dd30179c78c3a1448b328c25088300512e3cff0e2");
        String sigStr = tlsSigAPIv2.genSig("administrator",604800);
        System.out.println(sigStr);
    }
}

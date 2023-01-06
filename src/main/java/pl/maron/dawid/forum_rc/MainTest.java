package pl.maron.dawid.forum_rc;

import org.apache.commons.codec.digest.DigestUtils;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("mareczek" + DigestUtils.md5Hex("mareczek"));
        System.out.println("Paulina" + DigestUtils.md5Hex("Paulina"));
        System.out.println("Malwina" + DigestUtils.md5Hex("Malwina"));

    }
}

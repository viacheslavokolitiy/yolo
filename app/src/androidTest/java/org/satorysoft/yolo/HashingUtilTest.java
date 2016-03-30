package org.satorysoft.yolo;

import junit.framework.Assert;

import org.junit.Test;
import org.satorysoft.yolo.util.HashingUtil;

public class HashingUtilTest {

    @Test
    public void hash_should_not_be_null() throws Exception{
        String baseString = "baseString";

        Assert.assertNotNull(new HashingUtil().generateMD5String(baseString));
    }

    @Test
    public void hash_should_be_md5() throws Exception{
        String baseString = "baseString";

        String probablyMD5 = new HashingUtil().generateMD5String(baseString);

        Assert.assertNotNull(probablyMD5);

        String matchRule = "[a-fA-F0-9]{32}";

        Assert.assertTrue(probablyMD5.matches(matchRule));
    }
}

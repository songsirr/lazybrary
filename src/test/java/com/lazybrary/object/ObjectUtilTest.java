package com.lazybrary.object;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ObjectUtilTest {

    @Test
    void hasNullField_hasNull(){
        Pojo pojo = new Pojo(true);
        boolean f = ObjectUtil.hasNullField(pojo);
        Assertions.assertTrue(f);
    }

    @Test
    void hasNullField_hasNotNull(){
        Pojo pojo = new Pojo(false);
        boolean f = ObjectUtil.hasNullField(pojo);
        Assertions.assertFalse(f);
    }

    class Pojo {
        private String val1;

        private Integer val2;

        private Double val3;

        private SubPojo val4;

        public Pojo(boolean hasNull){
            if (hasNull){
                this.val1 = "foo";
                this.val2 = 1;
            } else {
                this.val1 = "var";
                this.val2 = 1;
                this.val3 = 1.0;
                this.val4 = new SubPojo();
            }
        }
    }

    class SubPojo {
        private String val1;

        public SubPojo() {
        }
    }
}
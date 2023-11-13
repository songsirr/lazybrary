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

    @Test
    void isNullObjectTest_empty(){
        EmptyPojo pojo = new EmptyPojo(true);
        boolean f = ObjectUtil.isNullObject(pojo);
        Assertions.assertTrue(f);
    }

    @Test
    void isNullObjectTest_not_empty(){
        EmptyPojo pojo = new EmptyPojo(false);
        boolean f = ObjectUtil.isNullObject(pojo);
        Assertions.assertFalse(f);
    }

    @Test
    void isNullObjectTest_has_primitive_type(){
        PriPojo pojo = new PriPojo("Hello");
        boolean f = ObjectUtil.isNullObject(pojo);
        Assertions.assertFalse(f);
    }

    @Test
    void removeEmptyStringFieldsTest(){
        EmptyPojo pojo = new EmptyPojo(false);
        pojo.setVal1("");

        ObjectUtil.removeEmptyStringFields(pojo);
        
        Assertions.assertNull(pojo.val1);
        Assertions.assertNotNull(pojo.val2);
    }

    static class Pojo {
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

    static class SubPojo {
        private String val1;

        public SubPojo() {
        }
    }

    static class EmptyPojo {
        private String val1;

        private String val2;

        public EmptyPojo(boolean isEmpty) {
            if (!isEmpty){
                this.val1 = "val1";
                this.val2 = "val2";
            }
        }

        public void setVal1(String val1) {
            this.val1 = val1;
        }

        public void setVal2(String val2) {
            this.val2 = val2;
        }
    }

    static class PriPojo {
        private int i;

        private String s;

        public PriPojo(int i, String s) {
            this.i = i;
            this.s = s;
        }

        public PriPojo(String s) {
            this.s = s;
        }
    }
}
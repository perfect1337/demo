//package ru.efimev.main;
//
//import org.junit.Test;
//
//import java.util.Map;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import org.junit.Assert.*;
//import static ru.efimev.main.Methods.collect;
//import ru.efimev.reflection.annotation.*;
//
//
//
//public class CollectTest {
//    final static String  SINGLE_EROR = "Ошибка в одиночном вызове метода";
//    static class EmptyClass {
//    }
//
//    static class SingleInvokeMethod {
//        @Invoke
//        public String getName() {
//            return "TestName";
//        }
//    }
//
//    static class MultiInvokeMethods {
//        @Invoke
//        public int getAge() {
//            return 30;
//        }
//
//        @Invoke
//        public String getCity() {
//            return "TestCity";
//        }
//    }
//
//    static class MethodWithParams {
//        @Invoke
//        public String getName(String prefix) {
//            return prefix + "TestName";
//        }
//    }
//
//    static class VoidMethod {
//        @Invoke
//        public void doSomething() {
//            System.out.println("Doing something");
//        }
//    }
//
//    static class SuperClass {
//        @Invoke
//        public String getCountry() {
//            return "TestCountry";
//        }
//    }
//
//    static class SubClass extends SuperClass {
//        @Invoke
//        public String getSubName() {
//            return "SubTestName";
//        }
//    }
//
//    static class ExceptionMethod {
//        @Invoke
//        public String getException() {
//            throw new RuntimeException("Test Exception");
//        }
//    }
//
//    static class PrivateMethod {
//        @Invoke
//        private String getPrivateName() {
//            return "PrivateTestName";
//        }
//    }
//
//    static class StaticMethod {
//        @Invoke
//        private static String getStaticName(){
//            return "TestName";
//        }
//    }
//
//    static class MethodWithoutAnnotation {
//        private static String getAnnotationName() {
//            return "TestName";
//        }
//    }
//
//    @Test
//    public void testEmptyClass() {
//        Map<String, Object> result = collect(EmptyClass.class);
//        assertTrue(result.isEmpty());
//    }
//
//    @Test
//    public void testSingleInvokeMethod() {
//        Map<String, Object> result = collect(SingleInvokeMethod.class);
//        assertEquals(1, result.size());
//        assertEquals("TestName", result.get("getName"));
//    }
//
//    @Test
//    public void testMultiInvokeMethods() {
//        Map<String, Object> result = collect(MultiInvokeMethods.class);
//        assertEquals(2, result.size());
//        assertEquals(30, result.get("getAge"));
//        assertEquals("TestCity", result.get("getCity"));
//    }
//
//    @Test
//    public void testMethodWithParams() {
//        Map<String, Object> result = collect(MethodWithParams.class);
//        assertTrue(result.isEmpty());
//    }
//
//    @Test
//    public void testVoidMethod() {
//        Map<String, Object> result = collect(VoidMethod.class);
//        assertTrue(result.isEmpty());
//    }
//
//    @Test
//    public void testSuperClassAndSubClass() {
//        Map<String, Object> result = collect(SubClass.class);
//        assertEquals(2, result.size());
//        assertEquals("TestCountry", result.get("getCountry"));
//        assertEquals("SubTestName", result.get("getSubName"));
//    }
//
//    @Test
//    public void testExceptionMethod() {
//        Map<String, Object> result = collect(ExceptionMethod.class);
//        assertTrue(result.isEmpty());
//    }
//
//    @Test
//    public void testPrivateMethod() {
//        Map<String, Object> result = collect(PrivateMethod.class);
//        assertEquals("PrivateTestName", result.get("getPrivateName"));
//    }
//
//    @Test
//    public void testMultipleClasses() {
//        Map<String, Object> result = collect(SingleInvokeMethod.class, MultiInvokeMethods.class);
//        assertEquals(3, result.size());
//        assertEquals("TestName", result.get("getName"));
//        assertEquals(30, result.get("getAge"));
//        assertEquals("TestCity", result.get("getCity"));
//    }
//
//    @Test
//    public void testMultipleClassesWithDuplicates() {
//        Map<String, Object> result = collect(SingleInvokeMethod.class, SingleInvokeMethod.class);
//        assertEquals(1, result.size());
//        assertEquals("TestName", result.get("getName"));
//    }
//    @Test
//    public void testStaticMethod() {
//        Map<String, Object> result = collect(StaticMethod.class);
//        assertEquals(1, result.size());
//        assertEquals("TestName", result.get("getStaticName"));
//    }
//    @Test
//    public void testMethodWithoutAnnotation(){
//        Map<String, Object> result = collect(MethodWithoutAnnotation.class);
//        assertTrue(result.isEmpty());
//    }
//
//
//}
//

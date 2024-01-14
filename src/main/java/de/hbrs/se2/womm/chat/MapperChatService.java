//package de.hbrs.se2.womm.services;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Base64;
//import java.util.List;
//
////}
//
//
//public class MapperChatService {
//
//    public static byte[][] encodeStringToByte(String[] stringArray){
//        byte[][] byteArray = new byte[stringArray.length][];
//
//        for (int i = 0; i < stringArray.length; i++) {
//            try {
//                byteArray[i] = stringArray[i].getBytes();
//                String base64Encoded = Base64.getEncoder().encodeToString(byteArray[i]);
////                System.out.println("Base64 encoded string: " + base64Encoded);
//            } catch (Exception e) {
//                System.out.println("Error encoding: " + stringArray[i]);
//            }
//        }
//        return byteArray;
//    }
//    public static byte[] encodeStringToByteArr(String[] stringArray) {
//        byte[][] byteArrArr = encodeStringToByte(stringArray);
//        byte[] byteArr = Arrays.deepToString(byteArrArr).getBytes();
//        return byteArr;
//    }
//    public static byte[] flattenByteArrArrToByteArr(byte[][]  byteArray){
////        String[] stringArr = new String[byteArray.length];
////        for (int i = 0; i < byteArray.length; i++) {
////            try {
////                stringArr[i] = new String(byteArray[i]);
//////                System.out.println("Decoded string: " + stringArr[i]);
////            } catch (Exception e) {
////                System.out.println("Error decoding: " + byteArray[i]);
////            }
////        }
////        return stringArr;
//        Arrays.stream(byteArray).flatMap(Arrays::stream).toArray(byte[][]::new);
//    }
//    public static String[] decodeByteToString(byte[]  byteArray){
//        String[] stringArr = new String[byteArray.length];
//        for (int i = 0; i < byteArray.length; i++) {
//            try {
//                stringArr[i] = new String(byteArray[i]);
////                System.out.println("Decoded string: " + stringArr[i]);
//            } catch (Exception e) {
//                System.out.println("Error decoding: " + byteArray[i]);
//            }
//        }
//        return stringArr;
//    }
//
//
//
//
//    public static void main(String[] args) {
//
//        String[] stringArray = new String[]{
//                "Dominik:::hi",
//                "Paula:::bye",
//                "Dominik:::hi",
//                "Paula:::bye",
//                "Dominik:::okidoki",
//        };
//        byte[][] byteArray = encodeStringToByte(stringArray);
//        String[] newString = decodeByteToString(byteArray);
//        List<String[]> list = new ArrayList<>(newString.length);
//        Arrays.stream(newString).iterator().forEachRemaining(s -> list.add(s.split(":::")));
//        System.out.println("list: " + list);
//        list.stream().forEach(x -> System.out.println("" + x[0] + ": " + x[1]));
//    }
//}
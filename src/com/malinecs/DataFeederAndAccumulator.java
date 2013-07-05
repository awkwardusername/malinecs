/*
 * DataFeederAndAccumulator.JAVA
 * Source file for the definition of the singleton class of the Data Feeder and Accumulator (DFAccu) module of MalInECS.
 * Date: 2013-07-05
 * Time: 01:00
 */

package com.malinecs;

/**
 * Singleton class for the Data Feeder and Accumulator (DFAccu) module.
 * @author Temoto-kun
 */
public class DataFeederAndAccumulator {
    public static DataFeederAndAccumulator instance = new DataFeederAndAccumulator();

    private DataFeederAndAccumulator() {}
}

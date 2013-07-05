/*
 * SimilarityWeighingEngine.JAVA
 * Source file containing the definition of the singleton class of the Similarity Weighing Engine (SWEng) module, a
 * subsystem of the Correlation Engine (CorrEng) module of MalInECS.
 * Date: 2013-07-05
 * Time: 01:36
 */

package com.malinecs.correlation_engine;

/**
 * Singleton class of the Similarity Weighing Engine (SWEng) module.
 * @author Temoto-kun
 */
public class SimilarityWeighingEngine {
    public static SimilarityWeighingEngine instance = new SimilarityWeighingEngine();

    private SimilarityWeighingEngine() {}
}

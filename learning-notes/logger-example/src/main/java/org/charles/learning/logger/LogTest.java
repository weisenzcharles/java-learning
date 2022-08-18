package org.charles.learning.logger;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {


    public static void main(String[] args) {

    }

    @Test
    public void jclLog() {
        Log log = LogFactory.getLog("jclLog");
        log.info("=====================================================================");
        log.info("jclLog");
        log.info("=====================================================================");
    }

    @Test
    public void slf4jLog() {
        Logger logger = LoggerFactory.getLogger("slf4j");
        logger.info("=====================================================================");
        logger.info("slf4j");
        logger.info("=====================================================================");
    }
}

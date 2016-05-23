package util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Util class to help in computations.
 */
public class BetCounter {


    private double convertFractionToDouble(String fraction){
        String[] fractionAray = fraction.split("/");
        return Double.parseDouble(fractionAray[0]) / Double.parseDouble(fractionAray[1]);
    }

    /**
     * Counts and formats returns for given stake and odds.
     * @param stake string stake
     * @param fractionOdd odds in fraction format
     * @return estimated returns = stake + stake * fractionOdd
     */
    public String countReturns(String stake, String fractionOdd){
        double odds = convertFractionToDouble(fractionOdd);
        double stakeDouble = Double.parseDouble(stake);
        double expectedReturns = stakeDouble + stakeDouble * odds;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format(expectedReturns).replace(',', '.');
    }
}

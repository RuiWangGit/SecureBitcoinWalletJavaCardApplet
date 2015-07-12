package de.tum.in.securebitcoinwallet.javacardapplet.test.tests;

import static org.junit.Assert.assertTrue;
import javax.smartcardio.CardException;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

import org.junit.Test;

import de.tum.in.securebitcoinwallet.javacardapplet.AppletInstructions;

public class UtilTest extends AppletTestBase {
	public UtilTest() throws CardException {
		super();
	}

	@Test
	public void testRemainingMemory() throws CardException {
		CommandAPDU apdu = new CommandAPDU(
				AppletInstructions.SECURE_BITCOIN_WALLET_CLA,
				AppletInstructions.INS_GET_REMAINING_MEMORY, 0, 0);

		ResponseAPDU response = smartCard.transmit(apdu);
		
		byte[] data = response.getData();
		
		System.out.println("Remaining Slots: " + ((data[0] << 8) + data[1]));
		
		assertTrue(commandSuccessful(response));
	}
}
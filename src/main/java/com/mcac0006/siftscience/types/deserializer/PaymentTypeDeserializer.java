/**
 * 
 */
package com.mcac0006.siftscience.types.deserializer;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.mcac0006.siftscience.types.PaymentType;

/**
 * @author <a href="mailto:matthew.cachia@gmail.com">Matthew Cachia</a>
 *
 */
public class PaymentTypeDeserializer extends JsonDeserializer<PaymentType> {

	/* (non-Javadoc)
	 * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser, org.codehaus.jackson.map.DeserializationContext)
	 */
	@Override
	public PaymentType deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
		
		ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
		return PaymentType.resolve(node.getTextValue());
	}

}

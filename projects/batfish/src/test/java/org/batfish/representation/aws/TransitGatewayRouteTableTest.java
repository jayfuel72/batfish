package org.batfish.representation.aws;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import org.batfish.common.util.BatfishObjectMapper;
import org.batfish.common.util.CommonUtil;
import org.junit.Test;

/** Tests for {@link TransitGatewayAttachment} */
public class TransitGatewayRouteTableTest {

  @Test
  public void testDeserialization() throws IOException {
    String text =
        CommonUtil.readResource("org/batfish/representation/aws/TransitGatewayRouteTableTest.json");

    JsonNode json = BatfishObjectMapper.mapper().readTree(text);
    Region region = new Region("r1");
    region.addConfigElement(json, null, null);

    /*
     * Only the available gateway should show up.
     */
    assertThat(
        region.getTransitGatewayRouteTables(),
        equalTo(
            ImmutableMap.of(
                "tgw-rtb-08262a9ed03306288",
                new TransitGatewayRouteTable(
                    "tgw-rtb-08262a9ed03306288", "tgw-044be4464fcc69aff", false, false))));
  }
}

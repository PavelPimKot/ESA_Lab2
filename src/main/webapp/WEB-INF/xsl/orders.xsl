<?xml version="1.0" ?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        version="3.0"
>
    <xsl:output method="html" indent="yes" media-type="text/html" encoding="UTF-8" />
    <xsl:template match="/">
        <html>
            <head>
                <title>API XSLT</title>
                <body>
                    <h1>Test XSLT Transformation</h1>
                    <xsl:apply-templates />
                </body>
            </head>
            <style>
                table, th, td {
                border: 1px solid black;
                }
            </style>
        </html>
    </xsl:template>
    <xsl:template match="ArrayList">
        <h2>List of orders</h2>
        <table>
            <tr>
                <th>id</th>
                <th>status</th>
                <th>cost</th>
                <th>orderDate</th>
                <th>deliveryDate</th>
            </tr>
            <xsl:for-each select="item">
                <tr>
                    <td><xsl:value-of select="id"/></td>
                    <td><xsl:value-of select="status"/></td>
                    <td><xsl:value-of select="cost"/></td>
                    <td><xsl:value-of select="orderDate"/></td>
                    <td><xsl:value-of select="deliveryDate"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>
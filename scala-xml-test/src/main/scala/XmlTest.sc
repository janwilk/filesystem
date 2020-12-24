
//val book: scala.xml.Elem = <book id="b20234">Magic of scala-xml</book>









val example = <Document xmlns="urn:iso:std:iso:20022:tech:xsd:pain.001.001.03">
  <CstmrCdtTrfInitn>
      <GrpHdr>
        <MsgId>Id_101</MsgId>
        <CreDztTm>2015-12-17T</CreDztTm>
        <NbOfTxs>1</NbOfTxs>
        <CtrlSum>100</CtrlSum>
        <InitgPty>
          <Id>
            <OrgId>
              <BICOrBEI>CINAUS6L</BICOrBEI>
            </OrgId>
          </Id>
        </InitgPty>
      </GrpHdr>
      <PmtInf>
        <PmtInfId>123456</PmtInfId>
        <PmtMtd>TRF</PmtMtd>
        <PmtTpInf>
          <SvcLvl>
            <Prtry>URGP</Prtry>
          </SvcLvl>
        </PmtTpInf>
        <ReqdExctnDt>2015-12-31</ReqdExctnDt>
        <Dbtr>
          <Nm>Name of debtor</Nm>
          <PstlAdr>
            <StrtNm>Name of street</StrtNm>
            <TwnNm>Name of town</TwnNm>
            <Ctry>CZ</Ctry>
          </PstlAdr>
        </Dbtr>
        <DbtrAcct>
          <Id>
            <IBAN>CZ6508000000192000145399</IBAN>
          </Id>
          <Ccy>CZK</Ccy>
        </DbtrAcct>
        <DbtrAgt>
          <FinInstnId>
            <BIC>CINAUS6L</BIC>
            <PstlAdr>
              <Ctry>CZ</Ctry>
            </PstlAdr>
          </FinInstnId>
        </DbtrAgt>
        <CdtTrfTxInf>
          <PmtId>
            <EndToEndId>/VS1234567890/SS1234567890/KS1234
            </EndToEndId>
          </PmtId>
          <Amt>
            <InstdAmt Ccy="CZK">100</InstdAmt>
          </Amt>
          <CdtrAgt>
            <FinInstnId>
              <BIC>CINAUS6L</BIC>
              <PstlAdr>
                <Ctry>CZ</Ctry>
              </PstlAdr>
            </FinInstnId>
          </CdtrAgt>
          <Cdtr>
            <Nm>Name of Creditor</Nm>
            <PstlAdr>
              <StrtNm>Street name</StrtNm>
              <BldgNb>21</BldgNb>
              <PstCd>22339</PstCd>
              <TwnNm>Name of Town</TwnNm>
              <Ctry>CZ</Ctry>
            </PstlAdr>
            <Id>
              <OrgId>
                <Othr>
                  <Id>1234</Id>
                </Othr>
              </OrgId>
            </Id>
          </Cdtr>
          <CdtrAcct>
            <Id>
              <IBAN>CZ6907101781240000004159</IBAN>
            </Id>
          </CdtrAcct>
          <InstrForDbtrAgt>MCFDI1987010101010112345678912345678
          </InstrForDbtrAgt>
          <Purp>
            <Prtry>0001</Prtry>
          </Purp>
          <RmtInf>
            <Ustrd>Unstructured inf, pot. inv. nmb.</Ustrd>
          </RmtInf>
        </CdtTrfTxInf>
      </PmtInf>
    </CstmrCdtTrfInitn>
  </Document>



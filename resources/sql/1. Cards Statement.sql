--CSV Cards Statement 
DECLARE
  l_IndivAccIDs   TStdIDTable := TStdIDTable();
BEGIN
  SELECT GC.AccountID
    BULK COLLECT INTO l_IndivAccIDs
    FROM CorpCard CC
    JOIN GPS_Card GC ON CC.CardID = GC.ID
   WHERE CC.CorpClientID = 2410
     AND TypeID = 20
     AND StateID = 20;
         
  pkp_PortalStatement.PrepareCardStmtPeriod('CORP@CORP', DATE '2017-08-01', DATE '2017-08-31', l_IndivAccIDs);
END;

SELECT ItemDate,
       EventDate,
       MaskedPan,
       CardToken,
       TypeName,
       FullName,
       Details,
       TrnCurrencyID,
       TrnCurrencyCode,       
       TrnAmount,       
       AccCurrencyID,
       AccCurrencyCode,       
       AccAmount,
       Rate,
       TrnFeeAmount,
       TrnFeeCurrencyID,
       TrnFeeCurrencyCode,
       ConvFeeAmount,
       ConvFeeCurrencyID,
       ConvFeeCurrencyCode,
       TotalAmount,
       MadeBy 
  FROM VP_CardStmtItem

--PDF Cards Statement
DECLARE
  l_IndivAccIDs   TStdIDTable := TStdIDTable();
BEGIN
  SELECT GC.AccountID
    BULK COLLECT INTO l_IndivAccIDs
    FROM CorpCard CC
    JOIN GPS_Card GC ON CC.CardID = GC.ID
   WHERE CC.CorpClientID = 2410
     AND TypeID = 20
     AND StateID = 20;
       
  pkp_PortalStatement.PrepareCardStmtMonth('CORP@CORP', DATE '2017-08-01', l_IndivAccIDs);
END;

--Summary
SELECT CorpClientID,
       CorpClientName,
       FromDate,
       TillDate,
       CurrencyID,
       CurrencyCode,
       MaskedPan,
       CardToken,
       ClientName,
       PhoneNo,
       OpenBalance,
       InMove,
       OutMove,
       CloseBalance,
       Priority
  FROM VP_CardStmtSum
/
--Item
SELECT ItemDate,
       EventDate,
       MaskedPan,
       CardToken,
       TypeName,
       FullName,
       Details,
       TrnCurrencyID,
       TrnCurrencyCode,       
       TrnAmount,       
       AccCurrencyID,
       AccCurrencyCode,       
       AccAmount,
       Rate,
       TrnFeeAmount,
       TrnFeeCurrencyID,
       TrnFeeCurrencyCode,
       ConvFeeAmount,
       ConvFeeCurrencyID,
       ConvFeeCurrencyCode,
       OpenBalance,
       TotalAmount,
       Balance,
       CloseBalance,
       MadeBy
  FROM VP_CardStmtItem
/

old
	<![CDATA[
            SELECT
                STATEMENTID,
                SUMMARYID,
                ACCOUNTNAME,
                OPENBAL,
                CLOSEBAL,
                ISSHARED,
                FULLNAME,
                DETAILS,
                ITEMDATE,
                EVENTDATE,
                TRNAMOUNT,
                TRNCURRENCYID,
                TRNCURRENCYCODE,
                ACCAMOUNT,
                ACCCURRENCYID,
                ACCCURRENCYCODE,
                RATE,
                TRNFEEAMOUNT,
                TRNFEECURRENCYID,
                TRNFEECURRENCYCODE,
                CONVFEEAMOUNT,
                CONVFEECURRENCYID,
                CONVFEECURRENCYCODE,
                TYPENAME,
                MADEBY
            FROM 
                VM_StatementItem
        ]]>
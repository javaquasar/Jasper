--PDF Card Report Statement
BEGIN
  pkp_PortalStatement.PrepareMainAccCardStmtMonth('CORP@CORP', DATE '2017-08-01');
END;

--Summary
SELECT ClientID,
       ClientName,
       FromDate,
       TillDate,
       Iban, 
       AccountName, 
       CurrencyCode,
       OutAmount,
       InAmount
  FROM vp_MainAccCardStmtSum
 
--Item
SELECT Iban,
       CurrencyCode,
       MaskedPan,
       Details,
       Phone,
       FullName,
       ItemDate,
       TypeName,
       OutAmount, 
       InAmount
  FROM vp_MainAccCardStmtItem
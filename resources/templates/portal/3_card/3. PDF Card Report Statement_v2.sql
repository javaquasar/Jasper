--PDF Card Report Statement
BEGIN
  pkp_PortalStatement.PrepareMainAccCardStmtMonth('CORP@CORP', DATE '2017-08-01');
END;

--Summary
SELECT ClientID,
       ClientName,
       FromDate,
       TillDate,
       CurrencyID,
       CurrencyCode,
       Iban, 
       AccountName, 
       OutAmount,
       InAmount
  FROM vp_MainAccCardStmtSum
 
--Item
SELECT CurrencyID,
       CurrencyCode,
       Iban,
       CardID,
       MaskedPan,
       Details,
       PhoneNo,
       FullName,
       ItemDate,
       TypeName,
       OutAmount, 
       InAmount
  FROM vp_MainAccCardStmtItem
--CSV Main account Statement
BEGIN
  pkp_PortalStatement.PrepareMainAccStmtPeriod('CORP@CORP', DATE '2017-08-01', DATE '2017-08-22');
END;

SELECT ItemDate,  
       Iban,
       AccountName,
       TypeName,
       FullName,
       Details,
       CurrencyCode,
       Amount
  FROM VP_MainAccStmtItem
 
--PDF Main account Statement
BEGIN
  pkp_PortalStatement.PrepareMainAccStmtMonth('CORP@CORP', DATE '2017-08-01');
END;

--Summary
SELECT ClientID,
       ClientName,
       FromDate,
       TillDate,
       Iban, 
       AccountName, 
       CurrencyCode,
       OpenBal,
       InMove,
       OutMove,
       CloseBal
  FROM VP_MainAccStmtSum
 
--Item
SELECT Iban,
       CurrencyCode,
       ItemDate,
       TypeName,
       FullName,
       Details,
       OpenBal,
       Amount,
       Bal,
       CloseBal
  FROM VP_MainAccStmtItem
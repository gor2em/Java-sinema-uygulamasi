/*id resetle*/
DBCC CHECKIDENT ('Filmler', RESEED, 0)
GO

/*i�erik sil*/

DELETE FROM filmler
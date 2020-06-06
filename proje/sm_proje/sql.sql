/*id resetle*/
DBCC CHECKIDENT ('Filmler', RESEED, 0)
GO

/*içerik sil*/

DELETE FROM filmler
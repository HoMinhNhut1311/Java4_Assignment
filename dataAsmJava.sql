USE [master]
GO
/****** Object:  Database [Java4_Asm]    Script Date: 4/9/2024 7:57:53 AM ******/
CREATE DATABASE [Java4_Asm]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Java4_Asm', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\Java4_Asm.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Java4_Asm_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\Java4_Asm_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Java4_Asm] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Java4_Asm].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Java4_Asm] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Java4_Asm] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Java4_Asm] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Java4_Asm] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Java4_Asm] SET ARITHABORT OFF 
GO
ALTER DATABASE [Java4_Asm] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Java4_Asm] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Java4_Asm] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Java4_Asm] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Java4_Asm] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Java4_Asm] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Java4_Asm] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Java4_Asm] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Java4_Asm] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Java4_Asm] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Java4_Asm] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Java4_Asm] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Java4_Asm] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Java4_Asm] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Java4_Asm] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Java4_Asm] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Java4_Asm] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Java4_Asm] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Java4_Asm] SET  MULTI_USER 
GO
ALTER DATABASE [Java4_Asm] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Java4_Asm] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Java4_Asm] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Java4_Asm] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Java4_Asm] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Java4_Asm] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Java4_Asm] SET QUERY_STORE = ON
GO
ALTER DATABASE [Java4_Asm] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Java4_Asm]
GO
/****** Object:  Table [dbo].[Actor]    Script Date: 4/9/2024 7:57:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actor](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[birth] [datetime] NULL,
	[name] [nvarchar](100) NULL,
	[nationality] [nvarchar](100) NULL,
	[sex] [bit] NOT NULL,
	[srcImg] [varchar](255) NULL,
	[des] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 4/9/2024 7:57:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](100) NULL,
	[created_at] [datetime] NULL,
	[movie_id] [int] NULL,
	[user_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Episode]    Script Date: 4/9/2024 7:57:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Episode](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[description] [nvarchar](200) NULL,
	[episode_number] [int] NULL,
	[title] [nvarchar](100) NULL,
	[movie_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Genre]    Script Date: 4/9/2024 7:57:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Genre](
	[genre_id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[genre_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 4/9/2024 7:57:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[des] [nvarchar](max) NULL,
	[director] [nvarchar](100) NULL,
	[duration] [int] NOT NULL,
	[rating] [float] NOT NULL,
	[release] [datetime] NULL,
	[sourceTrailer] [varchar](300) NULL,
	[title] [nvarchar](200) NULL,
	[genre_id] [numeric](19, 0) NULL,
	[srcImg] [varchar](255) NULL,
	[visit] [numeric](19, 0) NULL,
	[sourceWatch] [varchar](300) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[movie_actor]    Script Date: 4/9/2024 7:57:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[movie_actor](
	[movie_id] [int] NOT NULL,
	[actor_id] [numeric](19, 0) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Review]    Script Date: 4/9/2024 7:57:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Review](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](100) NULL,
	[created_at] [datetime] NULL,
	[rating] [float] NOT NULL,
	[movie_id] [int] NULL,
	[user_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserRole]    Script Date: 4/9/2024 7:57:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRole](
	[role_id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[roleName] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 4/9/2024 7:57:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[email] [varchar](255) NULL,
	[name] [nvarchar](100) NULL,
	[password] [varchar](255) NULL,
	[username] [varchar](255) NULL,
	[role_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Movie] ADD  CONSTRAINT [moreThanZero]  DEFAULT ((0)) FOR [visit]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FKneum2y14eoklghxx362ymkafd] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([id])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FKneum2y14eoklghxx362ymkafd]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FKnnhjc0on4rr1g1sl32gshdgxe] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FKnnhjc0on4rr1g1sl32gshdgxe]
GO
ALTER TABLE [dbo].[Episode]  WITH CHECK ADD  CONSTRAINT [FKkseqgaqil9c99lv9lo23tbi8k] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([id])
GO
ALTER TABLE [dbo].[Episode] CHECK CONSTRAINT [FKkseqgaqil9c99lv9lo23tbi8k]
GO
ALTER TABLE [dbo].[Movie]  WITH CHECK ADD  CONSTRAINT [FKqtg1si8fcy7apk5lbv5nnwpxo] FOREIGN KEY([genre_id])
REFERENCES [dbo].[Genre] ([genre_id])
GO
ALTER TABLE [dbo].[Movie] CHECK CONSTRAINT [FKqtg1si8fcy7apk5lbv5nnwpxo]
GO
ALTER TABLE [dbo].[movie_actor]  WITH CHECK ADD  CONSTRAINT [FK2anlx6ycvy2nlm1o0ga9glpmu] FOREIGN KEY([actor_id])
REFERENCES [dbo].[Actor] ([id])
GO
ALTER TABLE [dbo].[movie_actor] CHECK CONSTRAINT [FK2anlx6ycvy2nlm1o0ga9glpmu]
GO
ALTER TABLE [dbo].[movie_actor]  WITH CHECK ADD  CONSTRAINT [FKi17y5929b8lhmtay3g1wo76e2] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([id])
GO
ALTER TABLE [dbo].[movie_actor] CHECK CONSTRAINT [FKi17y5929b8lhmtay3g1wo76e2]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK3tolkcf0pn0hof4755i0ekwcn] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK3tolkcf0pn0hof4755i0ekwcn]
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK7b1vpdhhlnm2i51lu4iwjkora] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movie] ([id])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK7b1vpdhhlnm2i51lu4iwjkora]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK1erb0m3aye7jwmc1a6l42dr7p] FOREIGN KEY([role_id])
REFERENCES [dbo].[UserRole] ([role_id])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK1erb0m3aye7jwmc1a6l42dr7p]
GO
USE [master]
GO
ALTER DATABASE [Java4_Asm] SET  READ_WRITE 
GO

package edu.psu.bd.cs.mau5073;
//---------------------------------------------------------------------------------
import java.util.HashMap;
//---------------------------------------------------------------------------------
public class CountryID {

    private HashMap<Integer,String> table = new HashMap<Integer, String>();

    //----------------------------------------------------------------------------------
    public String getCountryID (int id)
    {
        int x = id;
        String countryCode = table.get(x);

        return countryCode;
    }
    //----------------------------------------------------------------------------------
    public CountryID ()
    {
        initializeTable ();
    }
    //----------------------------------------------------------------------------------
    public void initializeTable ()
    {
        table.put (1, "UMI");
        table.put (2, "SGS");
        table.put (3, "HMD");
        table.put (4, "ATF");
        table.put (5, "IOT");
        table.put (6, "BVT");
        table.put (7, "ATA");
        table.put (8, "AFG");
        table.put (9, "NLD");
        table.put (10, "ANT");
        table.put (11, "ALB");
        table.put (12, "DZA");
        table.put (13, "ASM");
        table.put (14, "AND");
        table.put (15, "AGO");
        table.put (16, "AIA");
        table.put (17, "ATG");
        table.put (18, "ARE");
        table.put (19, "ARG");
        table.put (20, "ARM");
        table.put (21, "ABW");
        table.put (22, "AUS");
        table.put (23, "AZE");
        table.put (24, "BHS");
        table.put (25, "BHR");
        table.put (26, "BGD");
        table.put (27, "BRB");
        table.put (28, "BEL");
        table.put (29, "BLZ");
        table.put (30, "BEN");
        table.put (31, "BMU");
        table.put (32, "BTN");
        table.put (33, "BOL");
        table.put (34, "BIH");
        table.put (35, "BWA");
        table.put (36, "BRA");
        table.put (37, "GBR");
        table.put (38, "VGB");
        table.put (39, "BRN");
        table.put (40, "BGR");
        table.put (41, "BFA");
        table.put (42, "BDI");
        table.put (43, "CYM");
        table.put (44, "CHL");
        table.put (45, "COK");
        table.put (46, "CRI");
        table.put (47, "DJI");
        table.put (48, "DMA");
        table.put (49, "DOM");
        table.put (50, "ECU");
        table.put (51, "EGY");
        table.put (52, "SLV");
        table.put (53, "ERI");
        table.put (54, "ESP");
        table.put (55, "ZAF");
        table.put (56, "ETH");
        table.put (57, "FLK");
        table.put (58, "FJI");
        table.put (59, "PHL");
        table.put (60, "FRO");
        table.put (61, "GAB");
        table.put (62, "GMB");
        table.put (63, "GEO");
        table.put (64, "GHA");
        table.put (65, "GIB");
        table.put (66, "GRD");
        table.put (67, "GRL");
        table.put (68, "GLP");
        table.put (69, "GUM");
        table.put (70, "GTM");
        table.put (71, "GIN");
        table.put (72, "GNB");
        table.put (73, "GUY");
        table.put (74, "HTI");
        table.put (75, "HND");
        table.put (76, "HKG");
        table.put (77, "SJM");
        table.put (78, "IDN");
        table.put (79, "IND");
        table.put (80, "IRQ");
        table.put (81, "IRN");
        table.put (82, "IRL");
        table.put (83, "ISL");
        table.put (84, "ISR");
        table.put (85, "ITA");
        table.put (86, "TMP");
        table.put (87, "AUT");
        table.put (88, "JAM");
        table.put (89, "JPN");
        table.put (90, "YEM");
        table.put (91, "JOR");
        table.put (92, "CXR");
        table.put (93, "YUG");
        table.put (94, "KHM");
        table.put (95, "CMR");
        table.put (96, "CAN");
        table.put (97, "CPV");
        table.put (98, "KAZ");
        table.put (99, "KEN");
        table.put (100, "CAF");
        table.put (101, "CHN");
        table.put (102, "KGZ");
        table.put (103, "KIR");
        table.put (104, "COL");
        table.put (105, "COM");
        table.put (106, "COG");
        table.put (107, "COD");
        table.put (108, "CCK");
        table.put (109, "PRK");
        table.put (110, "KOR");
        table.put (111, "GRC");
        table.put (112, "HRV");
        table.put (113, "CUB");
        table.put (114, "KWT");
        table.put (115, "CYP");
        table.put (116, "LAO");
        table.put (117, "LVA");
        table.put (118, "LSO");
        table.put (119, "LBN");
        table.put (120, "LBR");
        table.put (121, "LBY");
        table.put (122, "LIE");
        table.put (123, "LTU");
        table.put (124, "LUX");
        table.put (125, "ESH");
        table.put (126, "MAC");
        table.put (127, "MDG");
        table.put (128, "MKD");
        table.put (129, "MWI");
        table.put (130, "MDV");
        table.put (131, "MYS");
        table.put (132, "MLI");
        table.put (133, "MLT");
        table.put (134, "MAR");
        table.put (135, "MHL");
        table.put (136, "MTQ");
        table.put (137, "MRT");
        table.put (138, "MUS");
        table.put (139, "MYT");
        table.put (140, "MEX");
        table.put (141, "FSM");
        table.put (142, "MDA");
        table.put (143, "MCO");
        table.put (144, "MNG");
        table.put (145, "MSR");
        table.put (146, "MOZ");
        table.put (147, "MMR");
        table.put (148, "NAM");
        table.put (149, "NRU");
        table.put (150, "NPL");
        table.put (151, "NIC");
        table.put (152, "NER");
        table.put (153, "NGA");
        table.put (154, "NIU");
        table.put (155, "NFK");
        table.put (156, "NOR");
        table.put (157, "CIV");
        table.put (158, "OMN");
        table.put (159, "PAK");
        table.put (160, "PLW");
        table.put (161, "PAN");
        table.put (162, "PNG");
        table.put (163, "PRY");
        table.put (164, "PER");
        table.put (165, "PCN");
        table.put (166, "MNP");
        table.put (167, "PRT");
        table.put (168, "PRI");
        table.put (170, "POL");
        table.put (171, "GNQ");
        table.put (172, "QAT");
        table.put (173, "FRA");
        table.put (174, "GUF");
        table.put (175, "PYF");
        table.put (176, "REU");
        table.put (177, "ROM");
        table.put (178, "RWA");
        table.put (179, "SWE");
        table.put (180, "SHN");
        table.put (181, "KNA");
        table.put (182, "LCA");
        table.put (183, "VCT");
        table.put (184, "SPM");
        table.put (185, "DEU");
        table.put (186, "SLB");
        table.put (187, "ZMB");
        table.put (188, "WSM");
        table.put (189, "SMR");
        table.put (190, "STP");
        table.put (191, "SAU");
        table.put (192, "SEN");
        table.put (193, "SYC");
        table.put (194, "SLE");
        table.put (195, "SGP");
        table.put (196, "SVK");
        table.put (197, "SVN");
        table.put (198, "SOM");
        table.put (199, "LKA");
        table.put (200, "SDN");
        table.put (201, "FIN");
        table.put (202, "SUR");
        table.put (203, "SWZ");
        table.put (204, "CHE");
        table.put (205, "SYR");
        table.put (206, "TJK");
        table.put (207, "TWN");
        table.put (208, "TZA");
        table.put (209, "DNK");
        table.put (210, "THA");
        table.put (211, "TGO");
        table.put (212, "TKL");
        table.put (213, "TON");
        table.put (214, "TTO");
        table.put (215, "TCD");
        table.put (216, "CZE");
        table.put (217, "TUN");
        table.put (218, "TUR");
        table.put (219, "TKM");
        table.put (220, "TCA");
        table.put (221, "TUV");
        table.put (222, "UGA");
        table.put (223, "UKR");
        table.put (224, "HUN");
        table.put (225, "URY");
        table.put (226, "NCL");
        table.put (227, "NZL");
        table.put (228, "UZB");
        table.put (229, "BLR");
        table.put (230, "WLF");
        table.put (231, "VUT");
        table.put (232, "VAT");
        table.put (233, "VEN");
        table.put (234, "RUS");
        table.put (235, "VNM");
        table.put (236, "EST");
        table.put (237, "USA");
        table.put (238, "VIR");
        table.put (239, "ZWE");
        table.put (240, "PSE");

    } // initializeTable
//----------------------------------------------------------------------------------

    public static void main( String[] args )
    {
        CountryID idNum = new CountryID();
        System.out.println( idNum.getCountryID( 240 ) );
    }

}
PGDMP     +        	            v            winestoreDB    10.4    10.4 �    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16395    winestoreDB    DATABASE     �   CREATE DATABASE "winestoreDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Mexico.1252' LC_CTYPE = 'Spanish_Mexico.1252';
    DROP DATABASE "winestoreDB";
          	   developer    false                        2615    16848    Devwinestores    SCHEMA        CREATE SCHEMA "Devwinestores";
    DROP SCHEMA "Devwinestores";
          	   developer    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    4                        2615    16849 	   winestore    SCHEMA        CREATE SCHEMA winestore;
    DROP SCHEMA winestore;
          	   developer    false            	            2615    16648 
   winestores    SCHEMA        CREATE SCHEMA winestores;
    DROP SCHEMA winestores;
          	   developer    false                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                       0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    2                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                  false                       0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                       false    1            �            1259    17010    coffees    TABLE     �   CREATE TABLE public.coffees (
    cof_name character varying(32) NOT NULL,
    sup_id integer NOT NULL,
    price numeric(6,2) NOT NULL,
    sales integer DEFAULT 0 NOT NULL,
    total integer DEFAULT 0 NOT NULL
);
    DROP TABLE public.coffees;
       public      	   developer    false    4            �            1259    17129    customer    TABLE     L  CREATE TABLE winestore.customer (
    customer_id integer NOT NULL,
    nombre character varying(40) NOT NULL,
    apellido character varying NOT NULL,
    fecha_nacimiento date NOT NULL,
    country_code integer NOT NULL,
    email character varying(40) NOT NULL,
    telefono character varying(25) NOT NULL,
    direccion text
);
    DROP TABLE winestore.customer;
    	   winestore      	   developer    false    11            �            1259    17125    customer_country_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.customer_country_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE winestore.customer_country_code_seq;
    	   winestore    	   developer    false    241    11                       0    0    customer_country_code_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE winestore.customer_country_code_seq OWNED BY winestore.customer.country_code;
         	   winestore    	   developer    false    240            �            1259    17123    customer_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE winestore.customer_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE winestore.customer_customer_id_seq;
    	   winestore    	   developer    false    11    241                       0    0    customer_customer_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE winestore.customer_customer_id_seq OWNED BY winestore.customer.customer_id;
         	   winestore    	   developer    false    239            �            1259    25375 	   purchases    TABLE       CREATE TABLE winestore.purchases (
    purchase_id integer NOT NULL,
    costumer_id integer NOT NULL,
    date_of_purchase date NOT NULL,
    amount_of_purchase numeric(10,2) NOT NULL,
    amount_of_bottles integer NOT NULL,
    wine_store_id integer NOT NULL
);
     DROP TABLE winestore.purchases;
    	   winestore      	   developer    false    11            �            1259    25371    purchases_costumer_id_seq    SEQUENCE     �   CREATE SEQUENCE winestore.purchases_costumer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE winestore.purchases_costumer_id_seq;
    	   winestore    	   developer    false    245    11                       0    0    purchases_costumer_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE winestore.purchases_costumer_id_seq OWNED BY winestore.purchases.costumer_id;
         	   winestore    	   developer    false    243            �            1259    25369    purchases_purchase_id_seq    SEQUENCE     �   CREATE SEQUENCE winestore.purchases_purchase_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE winestore.purchases_purchase_id_seq;
    	   winestore    	   developer    false    245    11                       0    0    purchases_purchase_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE winestore.purchases_purchase_id_seq OWNED BY winestore.purchases.purchase_id;
         	   winestore    	   developer    false    242            �            1259    25373    purchases_wine_store_id_seq    SEQUENCE     �   CREATE SEQUENCE winestore.purchases_wine_store_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE winestore.purchases_wine_store_id_seq;
    	   winestore    	   developer    false    245    11            	           0    0    purchases_wine_store_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE winestore.purchases_wine_store_id_seq OWNED BY winestore.purchases.wine_store_id;
         	   winestore    	   developer    false    244            �            1259    16886 
   ref_colors    TABLE     v   CREATE TABLE winestore.ref_colors (
    color_code integer NOT NULL,
    color_name character varying(30) NOT NULL
);
 !   DROP TABLE winestore.ref_colors;
    	   winestore      	   developer    false    11            �            1259    16884    ref_colors_color_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.ref_colors_color_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE winestore.ref_colors_color_code_seq;
    	   winestore    	   developer    false    223    11            
           0    0    ref_colors_color_code_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE winestore.ref_colors_color_code_seq OWNED BY winestore.ref_colors.color_code;
         	   winestore    	   developer    false    222            �            1259    16894    ref_countries    TABLE     }   CREATE TABLE winestore.ref_countries (
    country_code integer NOT NULL,
    country_name character varying(30) NOT NULL
);
 $   DROP TABLE winestore.ref_countries;
    	   winestore      	   developer    false    11            �            1259    16892    ref_countries_country_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.ref_countries_country_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE winestore.ref_countries_country_code_seq;
    	   winestore    	   developer    false    11    225                       0    0    ref_countries_country_code_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE winestore.ref_countries_country_code_seq OWNED BY winestore.ref_countries.country_code;
         	   winestore    	   developer    false    224            �            1259    16868    ref_grape_varieties    TABLE     �   CREATE TABLE winestore.ref_grape_varieties (
    grape_variety_code integer NOT NULL,
    grape_variety_name character varying(30) NOT NULL
);
 *   DROP TABLE winestore.ref_grape_varieties;
    	   winestore      	   developer    false    11            �            1259    16866 *   ref_grape_varieties_grape_variety_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.ref_grape_varieties_grape_variety_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 D   DROP SEQUENCE winestore.ref_grape_varieties_grape_variety_code_seq;
    	   winestore    	   developer    false    221    11                       0    0 *   ref_grape_varieties_grape_variety_code_seq    SEQUENCE OWNED BY        ALTER SEQUENCE winestore.ref_grape_varieties_grape_variety_code_seq OWNED BY winestore.ref_grape_varieties.grape_variety_code;
         	   winestore    	   developer    false    220            �            1259    16954    ref_regions    TABLE     �   CREATE TABLE winestore.ref_regions (
    region_code integer NOT NULL,
    region_name character varying(30) NOT NULL,
    country_code integer NOT NULL
);
 "   DROP TABLE winestore.ref_regions;
    	   winestore      	   developer    false    11            �            1259    16967    ref_regions_country_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.ref_regions_country_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE winestore.ref_regions_country_code_seq;
    	   winestore    	   developer    false    11    227                       0    0    ref_regions_country_code_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE winestore.ref_regions_country_code_seq OWNED BY winestore.ref_regions.country_code;
         	   winestore    	   developer    false    228            �            1259    16950    ref_regions_region_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.ref_regions_region_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE winestore.ref_regions_region_code_seq;
    	   winestore    	   developer    false    227    11                       0    0    ref_regions_region_code_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE winestore.ref_regions_region_code_seq OWNED BY winestore.ref_regions.region_code;
         	   winestore    	   developer    false    226            �            1259    17097    ref_vineyards    TABLE        CREATE TABLE winestore.ref_vineyards (
    vineyard_code integer NOT NULL,
    vineyard_name character varying(30) NOT NULL
);
 $   DROP TABLE winestore.ref_vineyards;
    	   winestore      	   developer    false    11            �            1259    17095    ref_vineyards_vineyard_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.ref_vineyards_vineyard_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE winestore.ref_vineyards_vineyard_code_seq;
    	   winestore    	   developer    false    11    237                       0    0    ref_vineyards_vineyard_code_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE winestore.ref_vineyards_vineyard_code_seq OWNED BY winestore.ref_vineyards.vineyard_code;
         	   winestore    	   developer    false    236            �            1259    16992 
   wine_store    TABLE     �  CREATE TABLE winestore.wine_store (
    wine_store_id integer NOT NULL,
    color_code integer NOT NULL,
    grape_variety_code integer NOT NULL,
    region_code integer,
    wine_name character varying(30) NOT NULL,
    price numeric(10,2) NOT NULL,
    wine_description text,
    url_picture_bottle text NOT NULL,
    country_code integer NOT NULL,
    vineyard_code integer,
    fecha_registro date,
    year_number character varying(20)
);
 !   DROP TABLE winestore.wine_store;
    	   winestore      	   developer    false    11            �            1259    16982    wine_store_color_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.wine_store_color_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE winestore.wine_store_color_code_seq;
    	   winestore    	   developer    false    11    233                       0    0    wine_store_color_code_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE winestore.wine_store_color_code_seq OWNED BY winestore.wine_store.color_code;
         	   winestore    	   developer    false    230            �            1259    17026    wine_store_country_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.wine_store_country_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE winestore.wine_store_country_code_seq;
    	   winestore    	   developer    false    11    233                       0    0    wine_store_country_code_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE winestore.wine_store_country_code_seq OWNED BY winestore.wine_store.country_code;
         	   winestore    	   developer    false    235            �            1259    16984 !   wine_store_grape_variety_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.wine_store_grape_variety_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE winestore.wine_store_grape_variety_code_seq;
    	   winestore    	   developer    false    11    233                       0    0 !   wine_store_grape_variety_code_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE winestore.wine_store_grape_variety_code_seq OWNED BY winestore.wine_store.grape_variety_code;
         	   winestore    	   developer    false    231            �            1259    16986    wine_store_region_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.wine_store_region_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE winestore.wine_store_region_code_seq;
    	   winestore    	   developer    false    11    233                       0    0    wine_store_region_code_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE winestore.wine_store_region_code_seq OWNED BY winestore.wine_store.region_code;
         	   winestore    	   developer    false    232            �            1259    17103    wine_store_vineyard_code_seq    SEQUENCE     �   CREATE SEQUENCE winestore.wine_store_vineyard_code_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE winestore.wine_store_vineyard_code_seq;
    	   winestore    	   developer    false    233    11                       0    0    wine_store_vineyard_code_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE winestore.wine_store_vineyard_code_seq OWNED BY winestore.wine_store.vineyard_code;
         	   winestore    	   developer    false    238            �            1259    16980    wine_store_wine_store_id_seq    SEQUENCE     �   CREATE SEQUENCE winestore.wine_store_wine_store_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE winestore.wine_store_wine_store_id_seq;
    	   winestore    	   developer    false    233    11                       0    0    wine_store_wine_store_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE winestore.wine_store_wine_store_id_seq OWNED BY winestore.wine_store.wine_store_id;
         	   winestore    	   developer    false    229            �            1259    33629    year    TABLE     P   CREATE TABLE winestore.year (
    year_number character varying(20) NOT NULL
);
    DROP TABLE winestore.year;
    	   winestore      	   developer    false    11            �            1259    16713 
   ref_colors    TABLE     {   CREATE TABLE winestores.ref_colors (
    "Color_Code" integer NOT NULL,
    "Color_Name" character varying(20) NOT NULL
);
 "   DROP TABLE winestores.ref_colors;
    
   winestores      	   developer    false    9            �            1259    16711    Ref_Colors_Color_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Ref_Colors_Color_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE winestores."Ref_Colors_Color_Code_seq";
    
   winestores    	   developer    false    206    9                       0    0    Ref_Colors_Color_Code_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE winestores."Ref_Colors_Color_Code_seq" OWNED BY winestores.ref_colors."Color_Code";
         
   winestores    	   developer    false    205            �            1259    16721    ref_countries    TABLE     �   CREATE TABLE winestores.ref_countries (
    "Country_Code" integer NOT NULL,
    "Country_Name" character varying(30) NOT NULL
);
 %   DROP TABLE winestores.ref_countries;
    
   winestores      	   developer    false    9            �            1259    16719    Ref_Countries_Country_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Ref_Countries_Country_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE winestores."Ref_Countries_Country_Code_seq";
    
   winestores    	   developer    false    9    208                       0    0    Ref_Countries_Country_Code_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE winestores."Ref_Countries_Country_Code_seq" OWNED BY winestores.ref_countries."Country_Code";
         
   winestores    	   developer    false    207            �            1259    16689    ref_grape_varieties    TABLE     �   CREATE TABLE winestores.ref_grape_varieties (
    "Grape_Variety_Code" integer NOT NULL,
    "Grape_Variety_Name" character varying NOT NULL
);
 +   DROP TABLE winestores.ref_grape_varieties;
    
   winestores      	   developer    false    9            �            1259    16687 *   Ref_Grape_Varieties_Grape_Variety_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Ref_Grape_Varieties_Grape_Variety_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 G   DROP SEQUENCE winestores."Ref_Grape_Varieties_Grape_Variety_Code_seq";
    
   winestores    	   developer    false    9    201                       0    0 *   Ref_Grape_Varieties_Grape_Variety_Code_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE winestores."Ref_Grape_Varieties_Grape_Variety_Code_seq" OWNED BY winestores.ref_grape_varieties."Grape_Variety_Code";
         
   winestores    	   developer    false    200            �            1259    16739    ref_regions    TABLE     �   CREATE TABLE winestores.ref_regions (
    "Region_Code" integer NOT NULL,
    "Country_Code" integer NOT NULL,
    "Region_Name" character varying(30) NOT NULL
);
 #   DROP TABLE winestores.ref_regions;
    
   winestores      	   developer    false    9            �            1259    16737    Ref_Regions_Country_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Ref_Regions_Country_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE winestores."Ref_Regions_Country_Code_seq";
    
   winestores    	   developer    false    211    9                       0    0    Ref_Regions_Country_Code_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE winestores."Ref_Regions_Country_Code_seq" OWNED BY winestores.ref_regions."Country_Code";
         
   winestores    	   developer    false    210            �            1259    16735    Ref_Regions_Region_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Ref_Regions_Region_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE winestores."Ref_Regions_Region_Code_seq";
    
   winestores    	   developer    false    9    211                       0    0    Ref_Regions_Region_Code_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE winestores."Ref_Regions_Region_Code_seq" OWNED BY winestores.ref_regions."Region_Code";
         
   winestores    	   developer    false    209            �            1259    16705    ref_vineyards    TABLE     �   CREATE TABLE winestores.ref_vineyards (
    "Vineyard_Code" integer NOT NULL,
    "Vineyard_Name" character varying(40) NOT NULL
);
 %   DROP TABLE winestores.ref_vineyards;
    
   winestores      	   developer    false    9            �            1259    16703    Ref_Vineyards_Vineyard_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Ref_Vineyards_Vineyard_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE winestores."Ref_Vineyards_Vineyard_Code_seq";
    
   winestores    	   developer    false    9    204                       0    0    Ref_Vineyards_Vineyard_Code_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE winestores."Ref_Vineyards_Vineyard_Code_seq" OWNED BY winestores.ref_vineyards."Vineyard_Code";
         
   winestores    	   developer    false    203            �            1259    16771 
   wine_store    TABLE     �  CREATE TABLE winestores.wine_store (
    "Wine_Store_id" integer NOT NULL,
    "Color_Code" integer NOT NULL,
    "Country_Code" integer NOT NULL,
    "Grape_Variety_Code" integer NOT NULL,
    "Region_Code" integer NOT NULL,
    "Vineyard_Code" integer NOT NULL,
    "Year_Number" integer NOT NULL,
    "Wine_Name" character varying(40) NOT NULL,
    url_picture_bottle text NOT NULL,
    "Price" numeric(6,2) NOT NULL,
    "Wine_Description" text
);
 "   DROP TABLE winestores.wine_store;
    
   winestores      	   developer    false    9            �            1259    16759    Wine_Store_Color_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Wine_Store_Color_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE winestores."Wine_Store_Color_Code_seq";
    
   winestores    	   developer    false    219    9                       0    0    Wine_Store_Color_Code_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE winestores."Wine_Store_Color_Code_seq" OWNED BY winestores.wine_store."Color_Code";
         
   winestores    	   developer    false    213            �            1259    16761    Wine_Store_Country_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Wine_Store_Country_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE winestores."Wine_Store_Country_Code_seq";
    
   winestores    	   developer    false    9    219                       0    0    Wine_Store_Country_Code_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE winestores."Wine_Store_Country_Code_seq" OWNED BY winestores.wine_store."Country_Code";
         
   winestores    	   developer    false    214            �            1259    16763 !   Wine_Store_Grape_Variety_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Wine_Store_Grape_Variety_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 >   DROP SEQUENCE winestores."Wine_Store_Grape_Variety_Code_seq";
    
   winestores    	   developer    false    219    9                       0    0 !   Wine_Store_Grape_Variety_Code_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE winestores."Wine_Store_Grape_Variety_Code_seq" OWNED BY winestores.wine_store."Grape_Variety_Code";
         
   winestores    	   developer    false    215            �            1259    16765    Wine_Store_Region_Code_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Wine_Store_Region_Code_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE winestores."Wine_Store_Region_Code_seq";
    
   winestores    	   developer    false    9    219                       0    0    Wine_Store_Region_Code_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE winestores."Wine_Store_Region_Code_seq" OWNED BY winestores.wine_store."Region_Code";
         
   winestores    	   developer    false    216            �            1259    16767    Wine_Store_Vineyard_Number_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Wine_Store_Vineyard_Number_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE winestores."Wine_Store_Vineyard_Number_seq";
    
   winestores    	   developer    false    9    219                        0    0    Wine_Store_Vineyard_Number_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE winestores."Wine_Store_Vineyard_Number_seq" OWNED BY winestores.wine_store."Vineyard_Code";
         
   winestores    	   developer    false    217            �            1259    16757    Wine_Store_Wine_Store_id_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Wine_Store_Wine_Store_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE winestores."Wine_Store_Wine_Store_id_seq";
    
   winestores    	   developer    false    9    219            !           0    0    Wine_Store_Wine_Store_id_seq    SEQUENCE OWNED BY     i   ALTER SEQUENCE winestores."Wine_Store_Wine_Store_id_seq" OWNED BY winestores.wine_store."Wine_Store_id";
         
   winestores    	   developer    false    212            �            1259    16769    Wine_Store_Year_Number_seq    SEQUENCE     �   CREATE SEQUENCE winestores."Wine_Store_Year_Number_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE winestores."Wine_Store_Year_Number_seq";
    
   winestores    	   developer    false    219    9            "           0    0    Wine_Store_Year_Number_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE winestores."Wine_Store_Year_Number_seq" OWNED BY winestores.wine_store."Year_Number";
         
   winestores    	   developer    false    218            �            1259    16698    years    TABLE     F   CREATE TABLE winestores.years (
    "Year_Number" integer NOT NULL
);
    DROP TABLE winestores.years;
    
   winestores      	   developer    false    9                       2604    17132    customer customer_id    DEFAULT     �   ALTER TABLE ONLY winestore.customer ALTER COLUMN customer_id SET DEFAULT nextval('winestore.customer_customer_id_seq'::regclass);
 F   ALTER TABLE winestore.customer ALTER COLUMN customer_id DROP DEFAULT;
    	   winestore    	   developer    false    239    241    241                       2604    17133    customer country_code    DEFAULT     �   ALTER TABLE ONLY winestore.customer ALTER COLUMN country_code SET DEFAULT nextval('winestore.customer_country_code_seq'::regclass);
 G   ALTER TABLE winestore.customer ALTER COLUMN country_code DROP DEFAULT;
    	   winestore    	   developer    false    240    241    241                       2604    25378    purchases purchase_id    DEFAULT     �   ALTER TABLE ONLY winestore.purchases ALTER COLUMN purchase_id SET DEFAULT nextval('winestore.purchases_purchase_id_seq'::regclass);
 G   ALTER TABLE winestore.purchases ALTER COLUMN purchase_id DROP DEFAULT;
    	   winestore    	   developer    false    242    245    245                       2604    25379    purchases costumer_id    DEFAULT     �   ALTER TABLE ONLY winestore.purchases ALTER COLUMN costumer_id SET DEFAULT nextval('winestore.purchases_costumer_id_seq'::regclass);
 G   ALTER TABLE winestore.purchases ALTER COLUMN costumer_id DROP DEFAULT;
    	   winestore    	   developer    false    243    245    245                       2604    25380    purchases wine_store_id    DEFAULT     �   ALTER TABLE ONLY winestore.purchases ALTER COLUMN wine_store_id SET DEFAULT nextval('winestore.purchases_wine_store_id_seq'::regclass);
 I   ALTER TABLE winestore.purchases ALTER COLUMN wine_store_id DROP DEFAULT;
    	   winestore    	   developer    false    244    245    245            �
           2604    16889    ref_colors color_code    DEFAULT     �   ALTER TABLE ONLY winestore.ref_colors ALTER COLUMN color_code SET DEFAULT nextval('winestore.ref_colors_color_code_seq'::regclass);
 G   ALTER TABLE winestore.ref_colors ALTER COLUMN color_code DROP DEFAULT;
    	   winestore    	   developer    false    223    222    223            �
           2604    16897    ref_countries country_code    DEFAULT     �   ALTER TABLE ONLY winestore.ref_countries ALTER COLUMN country_code SET DEFAULT nextval('winestore.ref_countries_country_code_seq'::regclass);
 L   ALTER TABLE winestore.ref_countries ALTER COLUMN country_code DROP DEFAULT;
    	   winestore    	   developer    false    224    225    225            �
           2604    16871 &   ref_grape_varieties grape_variety_code    DEFAULT     �   ALTER TABLE ONLY winestore.ref_grape_varieties ALTER COLUMN grape_variety_code SET DEFAULT nextval('winestore.ref_grape_varieties_grape_variety_code_seq'::regclass);
 X   ALTER TABLE winestore.ref_grape_varieties ALTER COLUMN grape_variety_code DROP DEFAULT;
    	   winestore    	   developer    false    221    220    221                        2604    16957    ref_regions region_code    DEFAULT     �   ALTER TABLE ONLY winestore.ref_regions ALTER COLUMN region_code SET DEFAULT nextval('winestore.ref_regions_region_code_seq'::regclass);
 I   ALTER TABLE winestore.ref_regions ALTER COLUMN region_code DROP DEFAULT;
    	   winestore    	   developer    false    226    227    227                       2604    16969    ref_regions country_code    DEFAULT     �   ALTER TABLE ONLY winestore.ref_regions ALTER COLUMN country_code SET DEFAULT nextval('winestore.ref_regions_country_code_seq'::regclass);
 J   ALTER TABLE winestore.ref_regions ALTER COLUMN country_code DROP DEFAULT;
    	   winestore    	   developer    false    228    227            
           2604    17100    ref_vineyards vineyard_code    DEFAULT     �   ALTER TABLE ONLY winestore.ref_vineyards ALTER COLUMN vineyard_code SET DEFAULT nextval('winestore.ref_vineyards_vineyard_code_seq'::regclass);
 M   ALTER TABLE winestore.ref_vineyards ALTER COLUMN vineyard_code DROP DEFAULT;
    	   winestore    	   developer    false    237    236    237                       2604    16995    wine_store wine_store_id    DEFAULT     �   ALTER TABLE ONLY winestore.wine_store ALTER COLUMN wine_store_id SET DEFAULT nextval('winestore.wine_store_wine_store_id_seq'::regclass);
 J   ALTER TABLE winestore.wine_store ALTER COLUMN wine_store_id DROP DEFAULT;
    	   winestore    	   developer    false    233    229    233                       2604    16996    wine_store color_code    DEFAULT     �   ALTER TABLE ONLY winestore.wine_store ALTER COLUMN color_code SET DEFAULT nextval('winestore.wine_store_color_code_seq'::regclass);
 G   ALTER TABLE winestore.wine_store ALTER COLUMN color_code DROP DEFAULT;
    	   winestore    	   developer    false    230    233    233                       2604    16997    wine_store grape_variety_code    DEFAULT     �   ALTER TABLE ONLY winestore.wine_store ALTER COLUMN grape_variety_code SET DEFAULT nextval('winestore.wine_store_grape_variety_code_seq'::regclass);
 O   ALTER TABLE winestore.wine_store ALTER COLUMN grape_variety_code DROP DEFAULT;
    	   winestore    	   developer    false    231    233    233                       2604    16998    wine_store region_code    DEFAULT     �   ALTER TABLE ONLY winestore.wine_store ALTER COLUMN region_code SET DEFAULT nextval('winestore.wine_store_region_code_seq'::regclass);
 H   ALTER TABLE winestore.wine_store ALTER COLUMN region_code DROP DEFAULT;
    	   winestore    	   developer    false    233    232    233                       2604    17028    wine_store country_code    DEFAULT     �   ALTER TABLE ONLY winestore.wine_store ALTER COLUMN country_code SET DEFAULT nextval('winestore.wine_store_country_code_seq'::regclass);
 I   ALTER TABLE winestore.wine_store ALTER COLUMN country_code DROP DEFAULT;
    	   winestore    	   developer    false    235    233                       2604    17105    wine_store vineyard_code    DEFAULT     �   ALTER TABLE ONLY winestore.wine_store ALTER COLUMN vineyard_code SET DEFAULT nextval('winestore.wine_store_vineyard_code_seq'::regclass);
 J   ALTER TABLE winestore.wine_store ALTER COLUMN vineyard_code DROP DEFAULT;
    	   winestore    	   developer    false    238    233            �
           2604    16716    ref_colors Color_Code    DEFAULT     �   ALTER TABLE ONLY winestores.ref_colors ALTER COLUMN "Color_Code" SET DEFAULT nextval('winestores."Ref_Colors_Color_Code_seq"'::regclass);
 J   ALTER TABLE winestores.ref_colors ALTER COLUMN "Color_Code" DROP DEFAULT;
    
   winestores    	   developer    false    205    206    206            �
           2604    16724    ref_countries Country_Code    DEFAULT     �   ALTER TABLE ONLY winestores.ref_countries ALTER COLUMN "Country_Code" SET DEFAULT nextval('winestores."Ref_Countries_Country_Code_seq"'::regclass);
 O   ALTER TABLE winestores.ref_countries ALTER COLUMN "Country_Code" DROP DEFAULT;
    
   winestores    	   developer    false    208    207    208            �
           2604    16692 &   ref_grape_varieties Grape_Variety_Code    DEFAULT     �   ALTER TABLE ONLY winestores.ref_grape_varieties ALTER COLUMN "Grape_Variety_Code" SET DEFAULT nextval('winestores."Ref_Grape_Varieties_Grape_Variety_Code_seq"'::regclass);
 [   ALTER TABLE winestores.ref_grape_varieties ALTER COLUMN "Grape_Variety_Code" DROP DEFAULT;
    
   winestores    	   developer    false    201    200    201            �
           2604    16742    ref_regions Region_Code    DEFAULT     �   ALTER TABLE ONLY winestores.ref_regions ALTER COLUMN "Region_Code" SET DEFAULT nextval('winestores."Ref_Regions_Region_Code_seq"'::regclass);
 L   ALTER TABLE winestores.ref_regions ALTER COLUMN "Region_Code" DROP DEFAULT;
    
   winestores    	   developer    false    209    211    211            �
           2604    16743    ref_regions Country_Code    DEFAULT     �   ALTER TABLE ONLY winestores.ref_regions ALTER COLUMN "Country_Code" SET DEFAULT nextval('winestores."Ref_Regions_Country_Code_seq"'::regclass);
 M   ALTER TABLE winestores.ref_regions ALTER COLUMN "Country_Code" DROP DEFAULT;
    
   winestores    	   developer    false    211    210    211            �
           2604    16708    ref_vineyards Vineyard_Code    DEFAULT     �   ALTER TABLE ONLY winestores.ref_vineyards ALTER COLUMN "Vineyard_Code" SET DEFAULT nextval('winestores."Ref_Vineyards_Vineyard_Code_seq"'::regclass);
 P   ALTER TABLE winestores.ref_vineyards ALTER COLUMN "Vineyard_Code" DROP DEFAULT;
    
   winestores    	   developer    false    203    204    204            �
           2604    16774    wine_store Wine_Store_id    DEFAULT     �   ALTER TABLE ONLY winestores.wine_store ALTER COLUMN "Wine_Store_id" SET DEFAULT nextval('winestores."Wine_Store_Wine_Store_id_seq"'::regclass);
 M   ALTER TABLE winestores.wine_store ALTER COLUMN "Wine_Store_id" DROP DEFAULT;
    
   winestores    	   developer    false    212    219    219            �
           2604    16775    wine_store Color_Code    DEFAULT     �   ALTER TABLE ONLY winestores.wine_store ALTER COLUMN "Color_Code" SET DEFAULT nextval('winestores."Wine_Store_Color_Code_seq"'::regclass);
 J   ALTER TABLE winestores.wine_store ALTER COLUMN "Color_Code" DROP DEFAULT;
    
   winestores    	   developer    false    213    219    219            �
           2604    16776    wine_store Country_Code    DEFAULT     �   ALTER TABLE ONLY winestores.wine_store ALTER COLUMN "Country_Code" SET DEFAULT nextval('winestores."Wine_Store_Country_Code_seq"'::regclass);
 L   ALTER TABLE winestores.wine_store ALTER COLUMN "Country_Code" DROP DEFAULT;
    
   winestores    	   developer    false    214    219    219            �
           2604    16777    wine_store Grape_Variety_Code    DEFAULT     �   ALTER TABLE ONLY winestores.wine_store ALTER COLUMN "Grape_Variety_Code" SET DEFAULT nextval('winestores."Wine_Store_Grape_Variety_Code_seq"'::regclass);
 R   ALTER TABLE winestores.wine_store ALTER COLUMN "Grape_Variety_Code" DROP DEFAULT;
    
   winestores    	   developer    false    219    215    219            �
           2604    16778    wine_store Region_Code    DEFAULT     �   ALTER TABLE ONLY winestores.wine_store ALTER COLUMN "Region_Code" SET DEFAULT nextval('winestores."Wine_Store_Region_Code_seq"'::regclass);
 K   ALTER TABLE winestores.wine_store ALTER COLUMN "Region_Code" DROP DEFAULT;
    
   winestores    	   developer    false    219    216    219            �
           2604    16779    wine_store Vineyard_Code    DEFAULT     �   ALTER TABLE ONLY winestores.wine_store ALTER COLUMN "Vineyard_Code" SET DEFAULT nextval('winestores."Wine_Store_Vineyard_Number_seq"'::regclass);
 M   ALTER TABLE winestores.wine_store ALTER COLUMN "Vineyard_Code" DROP DEFAULT;
    
   winestores    	   developer    false    217    219    219            �
           2604    16780    wine_store Year_Number    DEFAULT     �   ALTER TABLE ONLY winestores.wine_store ALTER COLUMN "Year_Number" SET DEFAULT nextval('winestores."Wine_Store_Year_Number_seq"'::regclass);
 K   ALTER TABLE winestores.wine_store ALTER COLUMN "Year_Number" DROP DEFAULT;
    
   winestores    	   developer    false    218    219    219            �          0    17010    coffees 
   TABLE DATA               H   COPY public.coffees (cof_name, sup_id, price, sales, total) FROM stdin;
    public    	   developer    false    234   U      �          0    17129    customer 
   TABLE DATA               �   COPY winestore.customer (customer_id, nombre, apellido, fecha_nacimiento, country_code, email, telefono, direccion) FROM stdin;
 	   winestore    	   developer    false    241   r      �          0    25375 	   purchases 
   TABLE DATA               �   COPY winestore.purchases (purchase_id, costumer_id, date_of_purchase, amount_of_purchase, amount_of_bottles, wine_store_id) FROM stdin;
 	   winestore    	   developer    false    245   �      �          0    16886 
   ref_colors 
   TABLE DATA               ?   COPY winestore.ref_colors (color_code, color_name) FROM stdin;
 	   winestore    	   developer    false    223   e      �          0    16894    ref_countries 
   TABLE DATA               F   COPY winestore.ref_countries (country_code, country_name) FROM stdin;
 	   winestore    	   developer    false    225         �          0    16868    ref_grape_varieties 
   TABLE DATA               X   COPY winestore.ref_grape_varieties (grape_variety_code, grape_variety_name) FROM stdin;
 	   winestore    	   developer    false    221   �      �          0    16954    ref_regions 
   TABLE DATA               P   COPY winestore.ref_regions (region_code, region_name, country_code) FROM stdin;
 	   winestore    	   developer    false    227   u      �          0    17097    ref_vineyards 
   TABLE DATA               H   COPY winestore.ref_vineyards (vineyard_code, vineyard_name) FROM stdin;
 	   winestore    	   developer    false    237   n      �          0    16992 
   wine_store 
   TABLE DATA               �   COPY winestore.wine_store (wine_store_id, color_code, grape_variety_code, region_code, wine_name, price, wine_description, url_picture_bottle, country_code, vineyard_code, fecha_registro, year_number) FROM stdin;
 	   winestore    	   developer    false    233   s      �          0    33629    year 
   TABLE DATA               .   COPY winestore.year (year_number) FROM stdin;
 	   winestore    	   developer    false    246   \      �          0    16713 
   ref_colors 
   TABLE DATA               D   COPY winestores.ref_colors ("Color_Code", "Color_Name") FROM stdin;
 
   winestores    	   developer    false    206   �      �          0    16721    ref_countries 
   TABLE DATA               K   COPY winestores.ref_countries ("Country_Code", "Country_Name") FROM stdin;
 
   winestores    	   developer    false    208   �      �          0    16689    ref_grape_varieties 
   TABLE DATA               ]   COPY winestores.ref_grape_varieties ("Grape_Variety_Code", "Grape_Variety_Name") FROM stdin;
 
   winestores    	   developer    false    201   �      �          0    16739    ref_regions 
   TABLE DATA               W   COPY winestores.ref_regions ("Region_Code", "Country_Code", "Region_Name") FROM stdin;
 
   winestores    	   developer    false    211         �          0    16705    ref_vineyards 
   TABLE DATA               M   COPY winestores.ref_vineyards ("Vineyard_Code", "Vineyard_Name") FROM stdin;
 
   winestores    	   developer    false    204   .      �          0    16771 
   wine_store 
   TABLE DATA               �   COPY winestores.wine_store ("Wine_Store_id", "Color_Code", "Country_Code", "Grape_Variety_Code", "Region_Code", "Vineyard_Code", "Year_Number", "Wine_Name", url_picture_bottle, "Price", "Wine_Description") FROM stdin;
 
   winestores    	   developer    false    219   K      �          0    16698    years 
   TABLE DATA               2   COPY winestores.years ("Year_Number") FROM stdin;
 
   winestores    	   developer    false    202   h      #           0    0    customer_country_code_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('winestore.customer_country_code_seq', 1, false);
         	   winestore    	   developer    false    240            $           0    0    customer_customer_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('winestore.customer_customer_id_seq', 67, true);
         	   winestore    	   developer    false    239            %           0    0    purchases_costumer_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('winestore.purchases_costumer_id_seq', 1, false);
         	   winestore    	   developer    false    243            &           0    0    purchases_purchase_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('winestore.purchases_purchase_id_seq', 54, true);
         	   winestore    	   developer    false    242            '           0    0    purchases_wine_store_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('winestore.purchases_wine_store_id_seq', 1, false);
         	   winestore    	   developer    false    244            (           0    0    ref_colors_color_code_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('winestore.ref_colors_color_code_seq', 59, true);
         	   winestore    	   developer    false    222            )           0    0    ref_countries_country_code_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('winestore.ref_countries_country_code_seq', 56, true);
         	   winestore    	   developer    false    224            *           0    0 *   ref_grape_varieties_grape_variety_code_seq    SEQUENCE SET     \   SELECT pg_catalog.setval('winestore.ref_grape_varieties_grape_variety_code_seq', 43, true);
         	   winestore    	   developer    false    220            +           0    0    ref_regions_country_code_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('winestore.ref_regions_country_code_seq', 5, true);
         	   winestore    	   developer    false    228            ,           0    0    ref_regions_region_code_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('winestore.ref_regions_region_code_seq', 87, true);
         	   winestore    	   developer    false    226            -           0    0    ref_vineyards_vineyard_code_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('winestore.ref_vineyards_vineyard_code_seq', 44, true);
         	   winestore    	   developer    false    236            .           0    0    wine_store_color_code_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('winestore.wine_store_color_code_seq', 1, false);
         	   winestore    	   developer    false    230            /           0    0    wine_store_country_code_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('winestore.wine_store_country_code_seq', 1, false);
         	   winestore    	   developer    false    235            0           0    0 !   wine_store_grape_variety_code_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('winestore.wine_store_grape_variety_code_seq', 1, false);
         	   winestore    	   developer    false    231            1           0    0    wine_store_region_code_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('winestore.wine_store_region_code_seq', 3, true);
         	   winestore    	   developer    false    232            2           0    0    wine_store_vineyard_code_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('winestore.wine_store_vineyard_code_seq', 1, false);
         	   winestore    	   developer    false    238            3           0    0    wine_store_wine_store_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('winestore.wine_store_wine_store_id_seq', 96, true);
         	   winestore    	   developer    false    229            4           0    0    Ref_Colors_Color_Code_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('winestores."Ref_Colors_Color_Code_seq"', 1, false);
         
   winestores    	   developer    false    205            5           0    0    Ref_Countries_Country_Code_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('winestores."Ref_Countries_Country_Code_seq"', 1, false);
         
   winestores    	   developer    false    207            6           0    0 *   Ref_Grape_Varieties_Grape_Variety_Code_seq    SEQUENCE SET     _   SELECT pg_catalog.setval('winestores."Ref_Grape_Varieties_Grape_Variety_Code_seq"', 1, false);
         
   winestores    	   developer    false    200            7           0    0    Ref_Regions_Country_Code_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('winestores."Ref_Regions_Country_Code_seq"', 1, false);
         
   winestores    	   developer    false    210            8           0    0    Ref_Regions_Region_Code_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('winestores."Ref_Regions_Region_Code_seq"', 1, false);
         
   winestores    	   developer    false    209            9           0    0    Ref_Vineyards_Vineyard_Code_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('winestores."Ref_Vineyards_Vineyard_Code_seq"', 1, false);
         
   winestores    	   developer    false    203            :           0    0    Wine_Store_Color_Code_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('winestores."Wine_Store_Color_Code_seq"', 1, false);
         
   winestores    	   developer    false    213            ;           0    0    Wine_Store_Country_Code_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('winestores."Wine_Store_Country_Code_seq"', 1, false);
         
   winestores    	   developer    false    214            <           0    0 !   Wine_Store_Grape_Variety_Code_seq    SEQUENCE SET     V   SELECT pg_catalog.setval('winestores."Wine_Store_Grape_Variety_Code_seq"', 1, false);
         
   winestores    	   developer    false    215            =           0    0    Wine_Store_Region_Code_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('winestores."Wine_Store_Region_Code_seq"', 1, false);
         
   winestores    	   developer    false    216            >           0    0    Wine_Store_Vineyard_Number_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('winestores."Wine_Store_Vineyard_Number_seq"', 1, false);
         
   winestores    	   developer    false    217            ?           0    0    Wine_Store_Wine_Store_id_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('winestores."Wine_Store_Wine_Store_id_seq"', 1, false);
         
   winestores    	   developer    false    212            @           0    0    Wine_Store_Year_Number_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('winestores."Wine_Store_Year_Number_seq"', 1, false);
         
   winestores    	   developer    false    218            6           2606    17016    coffees coffees_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.coffees
    ADD CONSTRAINT coffees_pkey PRIMARY KEY (cof_name);
 >   ALTER TABLE ONLY public.coffees DROP CONSTRAINT coffees_pkey;
       public      	   developer    false    234            ;           2606    17139    customer customer_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY winestore.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);
 C   ALTER TABLE ONLY winestore.customer DROP CONSTRAINT customer_pkey;
    	   winestore      	   developer    false    241            ?           2606    25382    purchases purchases_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY winestore.purchases
    ADD CONSTRAINT purchases_pkey PRIMARY KEY (purchase_id);
 E   ALTER TABLE ONLY winestore.purchases DROP CONSTRAINT purchases_pkey;
    	   winestore      	   developer    false    245            '           2606    16891    ref_colors ref_colors_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY winestore.ref_colors
    ADD CONSTRAINT ref_colors_pkey PRIMARY KEY (color_code);
 G   ALTER TABLE ONLY winestore.ref_colors DROP CONSTRAINT ref_colors_pkey;
    	   winestore      	   developer    false    223            )           2606    16899     ref_countries ref_countries_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY winestore.ref_countries
    ADD CONSTRAINT ref_countries_pkey PRIMARY KEY (country_code);
 M   ALTER TABLE ONLY winestore.ref_countries DROP CONSTRAINT ref_countries_pkey;
    	   winestore      	   developer    false    225            %           2606    16873 ,   ref_grape_varieties ref_grape_varieties_pkey 
   CONSTRAINT     }   ALTER TABLE ONLY winestore.ref_grape_varieties
    ADD CONSTRAINT ref_grape_varieties_pkey PRIMARY KEY (grape_variety_code);
 Y   ALTER TABLE ONLY winestore.ref_grape_varieties DROP CONSTRAINT ref_grape_varieties_pkey;
    	   winestore      	   developer    false    221            ,           2606    16960    ref_regions ref_regions_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY winestore.ref_regions
    ADD CONSTRAINT ref_regions_pkey PRIMARY KEY (region_code);
 I   ALTER TABLE ONLY winestore.ref_regions DROP CONSTRAINT ref_regions_pkey;
    	   winestore      	   developer    false    227            8           2606    17102     ref_vineyards ref_vineyards_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY winestore.ref_vineyards
    ADD CONSTRAINT ref_vineyards_pkey PRIMARY KEY (vineyard_code);
 M   ALTER TABLE ONLY winestore.ref_vineyards DROP CONSTRAINT ref_vineyards_pkey;
    	   winestore      	   developer    false    237            4           2606    17002    wine_store wine_store_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY winestore.wine_store
    ADD CONSTRAINT wine_store_pkey PRIMARY KEY (wine_store_id);
 G   ALTER TABLE ONLY winestore.wine_store DROP CONSTRAINT wine_store_pkey;
    	   winestore      	   developer    false    233            A           2606    41817    year year_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY winestore.year
    ADD CONSTRAINT year_pkey PRIMARY KEY (year_number);
 ;   ALTER TABLE ONLY winestore.year DROP CONSTRAINT year_pkey;
    	   winestore      	   developer    false    246                       2606    16718    ref_colors Ref_Colors_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY winestores.ref_colors
    ADD CONSTRAINT "Ref_Colors_pkey" PRIMARY KEY ("Color_Code");
 J   ALTER TABLE ONLY winestores.ref_colors DROP CONSTRAINT "Ref_Colors_pkey";
    
   winestores      	   developer    false    206                       2606    16726     ref_countries Ref_Countries_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY winestores.ref_countries
    ADD CONSTRAINT "Ref_Countries_pkey" PRIMARY KEY ("Country_Code");
 P   ALTER TABLE ONLY winestores.ref_countries DROP CONSTRAINT "Ref_Countries_pkey";
    
   winestores      	   developer    false    208                       2606    16697 ,   ref_grape_varieties Ref_Grape_Varieties_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY winestores.ref_grape_varieties
    ADD CONSTRAINT "Ref_Grape_Varieties_pkey" PRIMARY KEY ("Grape_Variety_Code");
 \   ALTER TABLE ONLY winestores.ref_grape_varieties DROP CONSTRAINT "Ref_Grape_Varieties_pkey";
    
   winestores      	   developer    false    201                       2606    16745    ref_regions Ref_Regions_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY winestores.ref_regions
    ADD CONSTRAINT "Ref_Regions_pkey" PRIMARY KEY ("Region_Code");
 L   ALTER TABLE ONLY winestores.ref_regions DROP CONSTRAINT "Ref_Regions_pkey";
    
   winestores      	   developer    false    211                       2606    16710     ref_vineyards Ref_Vineyards_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY winestores.ref_vineyards
    ADD CONSTRAINT "Ref_Vineyards_pkey" PRIMARY KEY ("Vineyard_Code");
 P   ALTER TABLE ONLY winestores.ref_vineyards DROP CONSTRAINT "Ref_Vineyards_pkey";
    
   winestores      	   developer    false    204                       2606    16785    wine_store Wine_Store_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY winestores.wine_store
    ADD CONSTRAINT "Wine_Store_pkey" PRIMARY KEY ("Wine_Store_id");
 J   ALTER TABLE ONLY winestores.wine_store DROP CONSTRAINT "Wine_Store_pkey";
    
   winestores      	   developer    false    219                       2606    16702    years Year_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY winestores.years
    ADD CONSTRAINT "Year_pkey" PRIMARY KEY ("Year_Number");
 ?   ALTER TABLE ONLY winestores.years DROP CONSTRAINT "Year_pkey";
    
   winestores      	   developer    false    202            9           1259    25409    country_code_fk    INDEX     O   CREATE INDEX country_code_fk ON winestore.customer USING btree (country_code);
 &   DROP INDEX winestore.country_code_fk;
    	   winestore      	   developer    false    241            -           1259    25425    fk_country_code    INDEX     Q   CREATE INDEX fk_country_code ON winestore.wine_store USING btree (country_code);
 &   DROP INDEX winestore.fk_country_code;
    	   winestore      	   developer    false    233            .           1259    17025    fki_color_code    INDEX     N   CREATE INDEX fki_color_code ON winestore.wine_store USING btree (color_code);
 %   DROP INDEX winestore.fki_color_code;
    	   winestore      	   developer    false    233            *           1259    16979    fki_country_code    INDEX     S   CREATE INDEX fki_country_code ON winestore.ref_regions USING btree (country_code);
 '   DROP INDEX winestore.fki_country_code;
    	   winestore      	   developer    false    227            <           1259    25431    fki_customer_id    INDEX     O   CREATE INDEX fki_customer_id ON winestore.purchases USING btree (costumer_id);
 &   DROP INDEX winestore.fki_customer_id;
    	   winestore      	   developer    false    245            /           1259    17047    fki_grape_variety_code    INDEX     ^   CREATE INDEX fki_grape_variety_code ON winestore.wine_store USING btree (grape_variety_code);
 -   DROP INDEX winestore.fki_grape_variety_code;
    	   winestore      	   developer    false    233            0           1259    17053    fki_region_code    INDEX     P   CREATE INDEX fki_region_code ON winestore.wine_store USING btree (region_code);
 &   DROP INDEX winestore.fki_region_code;
    	   winestore      	   developer    false    233            1           1259    17122    fki_vineyard_code    INDEX     T   CREATE INDEX fki_vineyard_code ON winestore.wine_store USING btree (vineyard_code);
 (   DROP INDEX winestore.fki_vineyard_code;
    	   winestore      	   developer    false    233            =           1259    25388    fki_wine_store_id    INDEX     S   CREATE INDEX fki_wine_store_id ON winestore.purchases USING btree (wine_store_id);
 (   DROP INDEX winestore.fki_wine_store_id;
    	   winestore      	   developer    false    245            2           1259    41823    fki_year_number    INDEX     P   CREATE INDEX fki_year_number ON winestore.wine_store USING btree (year_number);
 &   DROP INDEX winestore.fki_year_number;
    	   winestore      	   developer    false    233                       1259    16792    Country_Code_fk    INDEX     T   CREATE INDEX "Country_Code_fk" ON winestores.wine_store USING btree ("Color_Code");
 )   DROP INDEX winestores."Country_Code_fk";
    
   winestores      	   developer    false    219                       1259    16751    fki_Country_Code    INDEX     X   CREATE INDEX "fki_Country_Code" ON winestores.ref_regions USING btree ("Country_Code");
 *   DROP INDEX winestores."fki_Country_Code";
    
   winestores      	   developer    false    211                        1259    16803    fki_Grape_Variety_Code    INDEX     c   CREATE INDEX "fki_Grape_Variety_Code" ON winestores.wine_store USING btree ("Grape_Variety_Code");
 0   DROP INDEX winestores."fki_Grape_Variety_Code";
    
   winestores      	   developer    false    219            !           1259    16809    fki_Region_Code    INDEX     U   CREATE INDEX "fki_Region_Code" ON winestores.wine_store USING btree ("Region_Code");
 )   DROP INDEX winestores."fki_Region_Code";
    
   winestores      	   developer    false    219            "           1259    16815    fki_Vineyard_Code    INDEX     Y   CREATE INDEX "fki_Vineyard_Code" ON winestores.wine_store USING btree ("Vineyard_Code");
 +   DROP INDEX winestores."fki_Vineyard_Code";
    
   winestores      	   developer    false    219            #           1259    16821    fki_Year_Number    INDEX     U   CREATE INDEX "fki_Year_Number" ON winestores.wine_store USING btree ("Year_Number");
 )   DROP INDEX winestores."fki_Year_Number";
    
   winestores      	   developer    false    219            K           2606    25432    wine_store color_code    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.wine_store
    ADD CONSTRAINT color_code FOREIGN KEY (color_code) REFERENCES winestore.ref_colors(color_code) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY winestore.wine_store DROP CONSTRAINT color_code;
    	   winestore    	   developer    false    223    233    2855            J           2606    17152    ref_regions country_code    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.ref_regions
    ADD CONSTRAINT country_code FOREIGN KEY (country_code) REFERENCES winestore.ref_countries(country_code) ON UPDATE CASCADE ON DELETE CASCADE;
 E   ALTER TABLE ONLY winestore.ref_regions DROP CONSTRAINT country_code;
    	   winestore    	   developer    false    2857    225    227            L           2606    25437    wine_store country_code    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.wine_store
    ADD CONSTRAINT country_code FOREIGN KEY (color_code) REFERENCES winestore.ref_colors(color_code) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY winestore.wine_store DROP CONSTRAINT country_code;
    	   winestore    	   developer    false    223    233    2855            Q           2606    25410    customer country_code_fkk    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.customer
    ADD CONSTRAINT country_code_fkk FOREIGN KEY (country_code) REFERENCES winestore.ref_countries(country_code) ON UPDATE CASCADE ON DELETE CASCADE;
 F   ALTER TABLE ONLY winestore.customer DROP CONSTRAINT country_code_fkk;
    	   winestore    	   developer    false    241    2857    225            S           2606    33624    purchases customer_id    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.purchases
    ADD CONSTRAINT customer_id FOREIGN KEY (costumer_id) REFERENCES winestore.customer(customer_id) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY winestore.purchases DROP CONSTRAINT customer_id;
    	   winestore    	   developer    false    2875    245    241            N           2606    25462    wine_store grape_variety_code    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.wine_store
    ADD CONSTRAINT grape_variety_code FOREIGN KEY (grape_variety_code) REFERENCES winestore.ref_grape_varieties(grape_variety_code) ON UPDATE CASCADE ON DELETE CASCADE;
 J   ALTER TABLE ONLY winestore.wine_store DROP CONSTRAINT grape_variety_code;
    	   winestore    	   developer    false    221    233    2853            M           2606    25442    wine_store region_code    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.wine_store
    ADD CONSTRAINT region_code FOREIGN KEY (region_code) REFERENCES winestore.ref_regions(region_code) ON UPDATE CASCADE ON DELETE SET NULL;
 C   ALTER TABLE ONLY winestore.wine_store DROP CONSTRAINT region_code;
    	   winestore    	   developer    false    2860    227    233            O           2606    33646    wine_store vineyard_code    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.wine_store
    ADD CONSTRAINT vineyard_code FOREIGN KEY (vineyard_code) REFERENCES winestore.ref_vineyards(vineyard_code) ON UPDATE CASCADE ON DELETE SET NULL;
 E   ALTER TABLE ONLY winestore.wine_store DROP CONSTRAINT vineyard_code;
    	   winestore    	   developer    false    2872    233    237            R           2606    25383    purchases wine_store_id    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.purchases
    ADD CONSTRAINT wine_store_id FOREIGN KEY (wine_store_id) REFERENCES winestore.wine_store(wine_store_id) ON UPDATE CASCADE ON DELETE CASCADE;
 D   ALTER TABLE ONLY winestore.purchases DROP CONSTRAINT wine_store_id;
    	   winestore    	   developer    false    2868    245    233            P           2606    41829    wine_store year_number    FK CONSTRAINT     �   ALTER TABLE ONLY winestore.wine_store
    ADD CONSTRAINT year_number FOREIGN KEY (year_number) REFERENCES winestore.year(year_number) ON UPDATE CASCADE ON DELETE CASCADE;
 C   ALTER TABLE ONLY winestore.wine_store DROP CONSTRAINT year_number;
    	   winestore    	   developer    false    2881    246    233            E           2606    16793    wine_store Color_Code    FK CONSTRAINT     �   ALTER TABLE ONLY winestores.wine_store
    ADD CONSTRAINT "Color_Code" FOREIGN KEY ("Color_Code") REFERENCES winestores.ref_colors("Color_Code");
 E   ALTER TABLE ONLY winestores.wine_store DROP CONSTRAINT "Color_Code";
    
   winestores    	   developer    false    219    206    2839            C           2606    16746    ref_regions Country_Code    FK CONSTRAINT     �   ALTER TABLE ONLY winestores.ref_regions
    ADD CONSTRAINT "Country_Code" FOREIGN KEY ("Country_Code") REFERENCES winestores.ref_countries("Country_Code") ON UPDATE SET NULL ON DELETE CASCADE;
 H   ALTER TABLE ONLY winestores.ref_regions DROP CONSTRAINT "Country_Code";
    
   winestores    	   developer    false    211    2841    208            B           2606    16752    ref_countries Country_Code    FK CONSTRAINT     �   ALTER TABLE ONLY winestores.ref_countries
    ADD CONSTRAINT "Country_Code" FOREIGN KEY ("Country_Code") REFERENCES winestores.ref_countries("Country_Code") ON UPDATE SET NULL ON DELETE CASCADE;
 J   ALTER TABLE ONLY winestores.ref_countries DROP CONSTRAINT "Country_Code";
    
   winestores    	   developer    false    208    2841    208            D           2606    16787    wine_store Country_Code    FK CONSTRAINT     �   ALTER TABLE ONLY winestores.wine_store
    ADD CONSTRAINT "Country_Code" FOREIGN KEY ("Color_Code") REFERENCES winestores.ref_colors("Color_Code");
 G   ALTER TABLE ONLY winestores.wine_store DROP CONSTRAINT "Country_Code";
    
   winestores    	   developer    false    206    219    2839            F           2606    16798    wine_store Grape_Variety_Code    FK CONSTRAINT     �   ALTER TABLE ONLY winestores.wine_store
    ADD CONSTRAINT "Grape_Variety_Code" FOREIGN KEY ("Grape_Variety_Code") REFERENCES winestores.ref_grape_varieties("Grape_Variety_Code");
 M   ALTER TABLE ONLY winestores.wine_store DROP CONSTRAINT "Grape_Variety_Code";
    
   winestores    	   developer    false    2833    219    201            G           2606    16804    wine_store Region_Code    FK CONSTRAINT     �   ALTER TABLE ONLY winestores.wine_store
    ADD CONSTRAINT "Region_Code" FOREIGN KEY ("Region_Code") REFERENCES winestores.ref_regions("Region_Code");
 F   ALTER TABLE ONLY winestores.wine_store DROP CONSTRAINT "Region_Code";
    
   winestores    	   developer    false    211    2843    219            H           2606    16810    wine_store Vineyard_Code    FK CONSTRAINT     �   ALTER TABLE ONLY winestores.wine_store
    ADD CONSTRAINT "Vineyard_Code" FOREIGN KEY ("Vineyard_Code") REFERENCES winestores.ref_vineyards("Vineyard_Code");
 H   ALTER TABLE ONLY winestores.wine_store DROP CONSTRAINT "Vineyard_Code";
    
   winestores    	   developer    false    204    2837    219            I           2606    16816    wine_store Year_Number    FK CONSTRAINT     �   ALTER TABLE ONLY winestores.wine_store
    ADD CONSTRAINT "Year_Number" FOREIGN KEY ("Year_Number") REFERENCES winestores.years("Year_Number");
 F   ALTER TABLE ONLY winestores.wine_store DROP CONSTRAINT "Year_Number";
    
   winestores    	   developer    false    2835    219    202            �      x������ � �      �   '  x�]T���8<?��R_6F6�@n��x��HKi��MP7��@�5��}Ngg҉RB�H�rU=q��J�,'E��t��:/I)�
�1QEl	�z.�P��ח^�ݗ���W���A�Hߌ����L�!t��ʳ$%2[I	��,��q��Je�r�.\/ ��뫙��3J�RA-����h&=��<0��� 3"S����d%�'d^�j��P5*��p+;���e,�޶y1����ќ5��#H�
�@C2��F��hֺP������e�ӽ��m0�a�y�s��.�:3����˳>�њŸ#"(�j�{ة����^������/ݛϏ���cf�����a�g@RG,!M�T%�J�'��e�\�o� 8�z���\�7��"|x�95d�Ǧ�-c�`%�J�.�G�}X�0�0�矺;��]�����Ep8��l�V���G$��͝��2�E�T|˷2+���|k���������h�o�Є��o9s�{_T�n�r�+yQ�����?j��cd����8�yC��o�Kd�a'%�/T�IRnќ������/��O�z�?�I��}�_;[=����x�\|�pg+�b�4��X�J
�C!�N�V�oo����d�K����]���gK6[�l���H& ��c�:�z���>5�p+�i�7�'�%k�Z����F���[�B��EKyn��<'����v.�7��z��]5.�gq�����we֤7C[�N���z�@{[��o��1����A��G�UE��""�]��^,�!r���8�3ik      �   �   x�U�A�0��/�`����G�d�	G�zA�]'���(?�a�z�b"S|���7�������D��Uu��D�x����w��1�t�䦆r�\9�k�^����M�K�����E9�1��\;TWM�z^׆��؊��=k�>6u��]�)�`�*�WU|��U<d�=D�9�Jt      �   �   x�=�K�0D��)r�'�g��Jj�6,*�$/�3o&Fx6�c�ILW<�W�c�,n��Z8�b��Ćtv��K�0��H0�8�͑&#]�Κ���h����q��U$kSF��'M��X>��C�֤83@b��96�T~��"~ �t-�      �   �   x�%�K�0D��)8*�i��J��(M�|$\�3q1���xF3o���5��g0���zi�R�I���·�{�%�N��I�����ĐJ��f8�Kt@Z@���r]yK�����W�?�����G5�}:J���3V�j�bc%���+"� �/�      �   �   x�E�I�0E��)zT�2-�����FNZ	����.X�?�,*T�q)���m{��d��c *#�"G�{e��1:��M�����d��M��q��	�����0�*��ō�M�u��$���+��7X8��C�Ҵ�~�p?��n\���Qi��,*nP�F���6�      �   �   x�%�Ar�0E��)8A���� �1rFƤ����1��F����^�`z�κ－��il��=������� ���ƨ3S�Ӣ�����	�+Ui���YР�A� Ջ�(��R;��BT^�Tp�f�Y����l<`���|�kac��oٵ��o$�3�T�Ë�K��~�(�TFe��E�����Ta �\��Xʮ`�z���$�/����θ��+�q�,l��	�_���2KJ      �   �   x��]N�@���S��fm�]��؟�?U�8� q�܄����Ҍ����<GNN*'�����rerL-�"8��~T4�`s��m�2�\|L��g4���KN��}5��3�+����RȚ{�R�<���3�4K�E��gI��Oh���Դ��E)�i�>B������ml��9A̩Vz����6䪿�b/�}@۾�d��� �����q ��^uK��@���rT�ŻYK�$7�W�x@��P�      �   �  x��W�n��]S_Q��|��8;ZV�Ȓ!�zЀQ"KTyH����[^�Yf9�d1�Av���$_�SE�ٙM01�����sϹLB+Z�o��|F���ч���}�s<Ϻ5�be��0EXIv�WL�=�9��	�䌌��d�`
7�U��<�B��[I놑F��H#�e����-%bݰ�炔X]V��.%�gg����?�Kn��h��J��3���W�`�w��&����]3Y��,i��E���A&��Ro�n�r��pw,�U�1�˂���vTRRR$A�m���?k�����=���4w�m��u݇��f[z@�ו����7n�+͕x~�z}��O���,��x������Յ�O3χ��A�K��%���p`���b~>^�ȟǓ)���"ђ�t�M$����^'�܊���{�Sn-��*��v#v���9��a[�읐M[�La��V�v�O�������nB�<OFҫ��r6��$q��BR�-j�ޯ3R�lOIA+�{����W>��3�v2[�������Ad�i|1^LFsr��Ƌ�d�Zî��Y���	r�9#��D��H��i����Y)����_d�d���Q��f���*qr�`�<�7�FG������׏#��.�GQ?0��o�?z�؊c�8�dz3Y��/'��]D�:�@2���(Yqt��e�v:E�-W����%dR�*c�c�{yFFB1�����W�P�e�S�9�*$�9:�q*^Һ�57�bn
7�Ѝ#w��@�ҕ|N��Sb�pŮX��(�&����ܱ���g����E�X��}8�e5No��|��cМ�]�J�	}�ʎ�Pd�a%]Is�7 
:x̐��A�-�絢mـI.��)2qFh�uP��ݳ3<2y�yRK�ǖ�|�-8��O�s�gli�h[�'�6`巉#t����|'��\��t�w��|�㊸��qix$���WdBf�)�N.g7Wd6�\�-?2�ySw��F��5�Y~�{G�9W�6T2M�[��k��WA/�_j_����3��U~���E^S[��͠\Z�Ycs��&(궲k���Q�m�}cZa�M=4���7�Q����tzs;��ҩ���N��[�JR���?� ,�r��ޕ ��<��A*tIM�J���[s��Bg$c�=�_.Q\�)v:�B͌\����X��er��9ھ^�]��� �=��#	�$�������P�G��A�*x�=�B�otl5Y��������Z��2�����>a�f<g��{�ǋR����Zs��,�Z��J(۬���:���Z{�:�%��n���9�ܛ�3�j@8T���6w����q�`��1�o���&	�(�T�����7�H�8�����g="S�>]Z����ɣ8��`��f����O2�Ҁ�7�x��^�EY�E� ��#/�c��y:�f?dy׺'�O�(7�Z5_��x��k �^����� �����|����K��0�O�(k�����(��\�LC�$��OK%-����#-�4@���3�B���`F����r�Ѭx�|VP�_q��/m��:T�-�z�����:Ig�	M��R+�b�/nS+����@��bM1P���T)sL|���(:��3?�\P�vØ��0��x8ЅŻ�n��99O����\̏M�U���^>q2���̯�WT�Ĩ��]U���Lk�w�/%�N�ū�Oʬ= Y2=_7F��w��V���O�{q�z�Y�C��Fs����}�F�LlE鐷°��LFdךQ]��d$��/�Z���8����(�-�`�Ml0!�+������?�B�vz:�o���<�H�h�\�d�H/&�NNd�{����&��8�5���Dw����#�\ܒ�1�|��b�_���w��ok^ew9��� �$�CAv!�F0�9a�ō�4:E�Q��Y�������=}�tl�П:�
��{�@�#�aJL���Ggw��|;�ŽON������      �   N   x��;�0��w9���ȀK� &��.O��8��i�3�ȑ�{�s\�l+'mQ4���T�#L]w%�&����1      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     
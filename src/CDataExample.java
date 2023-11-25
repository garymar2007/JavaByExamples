import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.io.StringReader;

public class CDataExample {

    private final String TEMPLATE = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<head>\n" +
            "  <META http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
            "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "  <title></title><svg visibility=\"hidden\" style=\"display: none;\"><symbol id=\"icon-arrow-right-bold\" viewBox=\"1.2 2.1 22 21\"><path d=\"M11.704 22.098a1.48 1.48 0 01-1.02-.386 1.38 1.38 0 01-.413-.996c0-.375.146-.721.415-.978.411-.397 5.078-4.857 6.494-6.21H2.706c-1.035 0-1.506-.726-1.506-1.4 0-.679.471-1.406 1.506-1.406h14.472c-1.42-1.353-6.02-5.736-6.497-6.213-.292-.291-.445-.635-.442-.996a1.37 1.37 0 01.447-.975c.501-.479 1.354-.681 2.037.003.561.56 9.765 9.334 9.856 9.423l.173.163-.172.162c-.093.09-9.407 8.985-9.86 9.422-.264.258-.639.387-1.016.387\"></path></symbol></svg><style>\n" +
            "\n" +
            "                @font-face {\n" +
            "                font-display: optional;\n" +
            "                font-family: \"Market Sans\";\n" +
            "                font-style: normal;\n" +
            "                font-weight: 400;\n" +
            "                src: url(https://ir.ebaystatic.com/cr/v/c1/market-sans/v1.0/MarketSans-Regular-WebS.eot);\n" +
            "                src: url(https://ir.ebaystatic.com/cr/v/c1/market-sans/v1.0/MarketSans-Regular-WebS.eot?#iefix) format('embedded-opentype'),url(https://ir.ebaystatic.com/cr/v/c1/market-sans/v1.0/MarketSans-Regular-WebS.woff2) format('woff2'),url(https://ir.ebaystatic.com/cr/v/c1/market-sans/v1.0/MarketSans-Regular-WebS.woff) format('woff'),url(https://ir.ebaystatic.com/cr/v/c1/market-sans/v1.0/MarketSans-Regular-WebS.ttf) format('truetype'),url(https://ir.ebaystatic.com/cr/v/c1/market-sans/v1.0/MarketSans-Regular-WebS.svg#MarketSans-Regular-WebS) format('svg')\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container {\n" +
            "                background-color: #fff;\n" +
            "                font-family: 'Market Sans', sans-serif;\n" +
            "                font-size: 0.9em;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container a {\n" +
            "                color: #006efc;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container .title {\n" +
            "                display: flex;\n" +
            "                align-items: flex-end;\n" +
            "                justify-content: space-between;\n" +
            "                margin: 10px 0 10px 0;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container .title h2 {\n" +
            "                font-size: 20px;\n" +
            "                color: #151e27;\n" +
            "                font-weight: normal;\n" +
            "                margin: 0;\n" +
            "                padding-right: 25px;\n" +
            "                letter-spacing: 0;\n" +
            "                white-space: nowrap;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container .title .heading-line {\n" +
            "                height: 1px;\n" +
            "                width: 100%;\n" +
            "                background-color: #BABABA;\n" +
            "                position: relative;\n" +
            "                top: -10px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container .content {\n" +
            "                margin: 0 10px 10px 10px;\n" +
            "                line-height: 20px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container .content p {\n" +
            "                margin: 0 !important;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-separator {\n" +
            "                height: 1px;\n" +
            "                border-bottom: 1px solid #ccc;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-photos a {\n" +
            "                cursor: pointer;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-photos img {\n" +
            "                height: auto;\n" +
            "                width: auto;\n" +
            "                max-width: 100%;\n" +
            "                max-height: 600px;\n" +
            "                margin: 0 auto;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle div {\n" +
            "                padding: 10px 0;\n" +
            "                margin: 0 auto;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle-title {\n" +
            "                border-bottom: 1px solid #ccc;\n" +
            "                text-align: left;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle-title span {\n" +
            "                font-size: 1.6em;\n" +
            "                font-weight: bold;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle-overview {\n" +
            "                padding: 0 !important;\n" +
            "                width: 100%;\n" +
            "                display: table;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle-overview div {\n" +
            "                float: left;\n" +
            "                padding: 5px 0;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle-overview div.overview-title {\n" +
            "                text-align: left;\n" +
            "                font-weight: bold;\n" +
            "                width: 40%;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle-overview div.overview-value {\n" +
            "                text-align: left;\n" +
            "                margin-left: 10px;\n" +
            "                width: 50%;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-mpg {\n" +
            "                border: 1px solid #ccc;\n" +
            "                border-radius: 5px;\n" +
            "                width: 100%;\n" +
            "                float: left;\n" +
            "                overflow: auto;\n" +
            "                padding: 0;\n" +
            "                text-align: center;\n" +
            "                margin: 10px auto !important;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-mpg-details {\n" +
            "                display: inline-block;\n" +
            "                margin: 0 auto !important;\n" +
            "                padding: 0 !important;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-mpg-details div {\n" +
            "                float: left;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-mpg span {\n" +
            "                font-size: 1.5em;\n" +
            "                font-weight: bold;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-small-silver-text {\n" +
            "                font-size: 0.8em;\n" +
            "                color: #bbb;\n" +
            "                margin: 0 !important;\n" +
            "                padding: 0 !important;\n" +
            "                }\n" +
            "\n" +
            "                .clear-both {\n" +
            "                clear: both;\n" +
            "                width: 0;\n" +
            "                height: 0;\n" +
            "                margin: 0 !important;\n" +
            "                padding: 0 !important;\n" +
            "                }\n" +
            "\n" +
            "                .border-bottom {\n" +
            "                padding-bottom: 10px;\n" +
            "                margin-bottom: 10px;\n" +
            "                margin-top: 10px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-logo {\n" +
            "                width: 98%;\n" +
            "                margin: 1%;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-logo img {\n" +
            "                max-width: 100%;\n" +
            "                max-height: 150px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-phonetracking {\n" +
            "                text-align: center;\n" +
            "                width: 98%;\n" +
            "                margin: 1%;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-storelink {\n" +
            "                text-align: center;\n" +
            "                color: #006efc !important;\n" +
            "                text-decoration: none !important;\n" +
            "                font-weight: bold !important;\n" +
            "                font-size: 14px line-height: 1.43;\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-viewallphotos:hover {\n" +
            "                background: #00509d;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-phonenumber {\n" +
            "                width: 260px;\n" +
            "                background-color: #3665f3;\n" +
            "                padding: 10px 0 10px 0;\n" +
            "                margin: 53px auto 0 auto;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-phonenumber span {\n" +
            "                height: 24px;\n" +
            "                font-size: 20px;\n" +
            "                text-align: center;\n" +
            "                color: #ffffff;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-phonenumber a {\n" +
            "                height: 24px;\n" +
            "                font-size: 20px;\n" +
            "                text-align: center;\n" +
            "                color: #ffffff;\n" +
            "                text-decoration: none;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-desc-btn {\n" +
            "                margin-top: 30px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-photos {\n" +
            "                width: 98%;\n" +
            "                margin: 1%;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle {\n" +
            "                text-align: center;\n" +
            "                margin: 11px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-viewallphotos-container {\n" +
            "                text-align: center;\n" +
            "                display: block;\n" +
            "                width: 100%;\n" +
            "                z-index: 9993;\n" +
            "                margin-top: 10px;\n" +
            "                }\n" +
            "\n" +
            "                .view-all-images {\n" +
            "                display: none;\n" +
            "                margin-top: 10px;\n" +
            "                color: #3366cc;\n" +
            "                text-align: center;\n" +
            "                max-width: 640px;\n" +
            "                }\n" +
            "\n" +
            "                .view-all-images a {\n" +
            "                text-decoration: none;\n" +
            "                width: 49%;\n" +
            "                margin: 5px 0;\n" +
            "                }\n" +
            "\n" +
            "                .vehicle-history-logo-img {\n" +
            "                max-width:200px;\n" +
            "                }\n" +
            "\n" +
            "                #vehicle-history-logo {\n" +
            "                display: flex;\n" +
            "                flex-direction: column;\n" +
            "                align-items: center;\n" +
            "                }\n" +
            "\n" +
            "                #div_vehicle_description {\n" +
            "                position: relative;\n" +
            "                }\n" +
            "\n" +
            "                .wordwrap {\n" +
            "                white-space: pre-wrap; /* CSS3 */\n" +
            "                white-space: -moz-pre-wrap; /* Firefox */\n" +
            "                white-space: -pre-wrap; /* Opera pre 7 */\n" +
            "                white-space: -o-pre-wrap; /* Opera 7 */\n" +
            "                word-wrap: break-word; /* IE */\n" +
            "                }\n" +
            "\n" +
            "                .overlay {\n" +
            "                position: fixed;\n" +
            "                top: 0;\n" +
            "                bottom: 0;\n" +
            "                left: 0;\n" +
            "                right: 0;\n" +
            "                background: rgba(0, 0, 0, 0.3);\n" +
            "                transition: opacity 500ms;\n" +
            "                visibility: hidden;\n" +
            "                opacity: 0;\n" +
            "                z-index: 9990;\n" +
            "                }\n" +
            "\n" +
            "                .overlay:target {\n" +
            "                visibility: visible;\n" +
            "                opacity: 1;\n" +
            "                }\n" +
            "\n" +
            "                .popup {\n" +
            "                margin: 20px auto;\n" +
            "                padding: 0;\n" +
            "                background: #fff;\n" +
            "                border-radius: 0;\n" +
            "                width: 100%;\n" +
            "                position: relative;\n" +
            "                transition: all 5s ease-in-out;\n" +
            "                }\n" +
            "\n" +
            "                .popup .close {\n" +
            "                position: absolute;\n" +
            "                top: 15px;\n" +
            "                right: 15px;\n" +
            "                transition: all 200ms;\n" +
            "                font-size: 30px;\n" +
            "                font-weight: bold;\n" +
            "                text-decoration: none;\n" +
            "                color: #333;\n" +
            "                margin-top: -15px;\n" +
            "                margin-right: -10px;\n" +
            "                z-index: 9992;\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .popup .close:hover {\n" +
            "                color: #06D85F;\n" +
            "                }\n" +
            "\n" +
            "                .popup .content {\n" +
            "                max-height: 30%;\n" +
            "                overflow: auto;\n" +
            "                }\n" +
            "\n" +
            "                #popupGallery {\n" +
            "                visibility: visible;\n" +
            "                opacity: 1;\n" +
            "                background: none;\n" +
            "                position: relative;\n" +
            "                }\n" +
            "\n" +
            "                .contact-seller-box {\n" +
            "                font-weight: bold;\n" +
            "                }\n" +
            "\n" +
            "                /*\n" +
            "                * Accordion\n" +
            "                */\n" +
            "                /* Basic Accordion Styles */\n" +
            "                .accordion {\n" +
            "                width: 100%;\n" +
            "                }\n" +
            "\n" +
            "                .accordion input[name='panel'] {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .accordion label {\n" +
            "                position: relative;\n" +
            "                display: block;\n" +
            "                padding: 10px;\n" +
            "                border-bottom: 1px solid rgba(0, 0, 0, 0.15);\n" +
            "                font-weight: bold;\n" +
            "                cursor: pointer;\n" +
            "                transition: all 0.4s cubic-bezier(0.865, 0.14, 0.095, 0.87);\n" +
            "                }\n" +
            "\n" +
            "                .accordion label:after {\n" +
            "                border-style: solid;\n" +
            "                border-width: 1px 1px 0 0;\n" +
            "                content: '';\n" +
            "                display: inline-block;\n" +
            "                height: 0.45em;\n" +
            "                right: 1em;\n" +
            "                position: absolute;\n" +
            "                top: 1.1em;\n" +
            "                transform: rotate(-45deg);\n" +
            "                vertical-align: top;\n" +
            "                width: 0.45em;\n" +
            "                }\n" +
            "\n" +
            "                .accordion label:hover {\n" +
            "                color: #fff;\n" +
            "                background-color: #3665f3;\n" +
            "                }\n" +
            "\n" +
            "                .accordion input:checked + label {\n" +
            "                color: #fff;\n" +
            "                background-color: #3665f3;\n" +
            "                }\n" +
            "\n" +
            "                .accordion input:checked + label:after {\n" +
            "                transform: rotate(135deg);\n" +
            "                }\n" +
            "\n" +
            "                .accordion .accordion__content {\n" +
            "                -webkit-transition: opacity 1s ease-out;\n" +
            "                transition: height opacity 1s ease-out;\n" +
            "                overflow: hidden;\n" +
            "                opacity: 0;\n" +
            "                height: 0;\n" +
            "                position: relative;\n" +
            "                padding: 0 10px;\n" +
            "                border-bottom: 1px solid #ccc;\n" +
            "                font-size: 0.9em;\n" +
            "                }\n" +
            "\n" +
            "                input[name='panel']:checked ~ .accordion__content {\n" +
            "                opacity: 1;\n" +
            "                height: auto;\n" +
            "                padding: 10px;\n" +
            "                }\n" +
            "\n" +
            "                .vehicle-options {\n" +
            "                -webkit-padding-start: 0;\n" +
            "                margin-left: 16px;\n" +
            "                }\n" +
            "\n" +
            "                .all-photos-container {\n" +
            "                padding: 0 5px;\n" +
            "                text-align: center;\n" +
            "                }\n" +
            "\n" +
            "                .all-photos {\n" +
            "                display: block;\n" +
            "                height: auto;\n" +
            "                width: auto;\n" +
            "                max-width: 100%;\n" +
            "                max-height: 600px;\n" +
            "                margin: 5px auto;\n" +
            "                }\n" +
            "\n" +
            "                .button-show-more-options {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .contactus-desktop {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .contactus-mobile {\n" +
            "                display: block;\n" +
            "                }\n" +
            "\n" +
            "                .call-dealer {\n" +
            "                margin-bottom: 0;\n" +
            "                }\n" +
            "\n" +
            "                .photo-gallery {\n" +
            "                width: 100%;\n" +
            "                }\n" +
            "\n" +
            "                .photo-gallery a {\n" +
            "                text-decoration: none;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow {\n" +
            "                position: relative;\n" +
            "                width: 595px;\n" +
            "                height: 450px;\n" +
            "                margin: 20px auto 10em;\n" +
            "                }\n" +
            "\n" +
            "                @media only screen and (max-width: 768px) {\n" +
            "                #slideshow {\n" +
            "                width: 100%;\n" +
            "                height: auto;\n" +
            "                margin: 10px auto;\n" +
            "                }\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .command {\n" +
            "                position: absolute;\n" +
            "                top: 193px;\n" +
            "                width: 26px;\n" +
            "                height: 64px;\n" +
            "                display: inline-flex;\n" +
            "                flex-direction: column;\n" +
            "                justify-content: center;\n" +
            "                align-items: center;\n" +
            "                background-color: rgba(255, 255, 255, 0.45);\n" +
            "                }\n" +
            "\n" +
            "                @media only screen and (max-width: 768px) {\n" +
            "                #slideshow .command {\n" +
            "                position: absolute;\n" +
            "                top: calc(75vw - 34px);\n" +
            "                width: calc(50% - 2px);\n" +
            "                height: 32px;\n" +
            "                display: inline-flex;\n" +
            "                flex-direction: column;\n" +
            "                justify-content: center;\n" +
            "                align-items: center;\n" +
            "                border: solid 1px #333333;\n" +
            "                background-color: rgba(255, 255, 255, 0.45);\n" +
            "                }\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .command:hover {\n" +
            "                cursor: pointer;\n" +
            "                background-color: rgba(255, 255, 255, 0.8);\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .command > .command-icon {\n" +
            "                border: solid #333333;\n" +
            "                border-width: 0 3px 3px 0;\n" +
            "                display: inline-block;\n" +
            "                padding: 6px;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .prev.command {\n" +
            "                left: 0;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .prev.command > .command-icon {\n" +
            "                transform: rotate(135deg);\n" +
            "                -webkit-transform: rotate(135deg);\n" +
            "                margin-left: 6px;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .next.command {\n" +
            "                right: 0;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .next.command > .command-icon {\n" +
            "                transform: rotate(-45deg);\n" +
            "                -webkit-transform: rotate(-45deg);\n" +
            "                margin-right: 6px;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .prev, #slideshow .next {\n" +
            "                display: none;\n" +
            "                z-index: 9;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .container {\n" +
            "                position: relative;\n" +
            "                width: 595px;\n" +
            "                height: 450px;\n" +
            "                overflow: hidden;\n" +
            "                }\n" +
            "\n" +
            "                @media only screen and (max-width: 768px) {\n" +
            "                #slideshow .container {\n" +
            "                width: 100%;\n" +
            "                height: 75vw;\n" +
            "                }\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .slider-placeholder {\n" +
            "                position: absolute;\n" +
            "                left: 0;\n" +
            "                top: 0;\n" +
            "                width: 2800%;\n" +
            "                height: 450px;\n" +
            "                font-size: 0;\n" +
            "                white-space: nowrap;\n" +
            "                display: flex;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .slider-placeholder > .photo-container {\n" +
            "                /*height: 450px;*/\n" +
            "                width: 595px;\n" +
            "                display: inline-flex;\n" +
            "                flex-direction: column;\n" +
            "                justify-content: center;\n" +
            "                align-items: center;\n" +
            "                overflow: hidden;\n" +
            "                background: #ffffff;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .slider-placeholder img {\n" +
            "                display: block;\n" +
            "                width: 100%;\n" +
            "                max-height: none;\n" +
            "                }\n" +
            "\n" +
            "                @media only screen and (max-width: 768px) {\n" +
            "                #slideshow .slider-placeholder {\n" +
            "                width: 2800vw;\n" +
            "                height: 69vw;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .slider-placeholder > img {\n" +
            "                height: 75vw;\n" +
            "                width: 100vw;\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .slider-placeholder {\n" +
            "                -webkit-transition: all 1s;\n" +
            "                -moz-transition: all 1s;\n" +
            "                transition: all 1s;\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list {\n" +
            "                position: relative;\n" +
            "                top: 10px;\n" +
            "                padding: 0;\n" +
            "                margin: 0;\n" +
            "                width: 100%;\n" +
            "                overflow-x: hidden;\n" +
            "                font-size: 0;\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list .thumbnail-list-wrapper {\n" +
            "                white-space: nowrap;\n" +
            "                overflow-x: visible;\n" +
            "                -webkit-transition: all 1s;\n" +
            "                -moz-transition: all 1s;\n" +
            "                transition: all 1s;\n" +
            "                display: flex;\n" +
            "                flex-direction: row;\n" +
            "                justify-content: center;\n" +
            "                align-items: center;\n" +
            "                }\n" +
            "\n" +
            "                @media only screen and (max-width: 768px) {\n" +
            "                .thumbnail-list {\n" +
            "                display: none;\n" +
            "                }\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list .thumbnail-item {\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list .thumbnail {\n" +
            "                display: inline-block;\n" +
            "                padding: 0;\n" +
            "                margin: 0;\n" +
            "                list-style: none;\n" +
            "                height: 80px;\n" +
            "                width: 80px;\n" +
            "                box-sizing: border-box;\n" +
            "                border: 1px solid transparent;\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list .thumbnail-item {\n" +
            "                margin-left: -1px;\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list .thumbnail-item:first-child {\n" +
            "                margin-left: 0;\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list .thumbnail .photo-container {\n" +
            "                width: 100%;\n" +
            "                height: 59px;\n" +
            "                display: flex;\n" +
            "                flex-direction: column;\n" +
            "                justify-content: center;\n" +
            "                align-items: center;\n" +
            "                overflow: hidden;\n" +
            "                margin-top: 10px;\n" +
            "                background: #ffffff;\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list .thumbnail img {\n" +
            "                width: 100%;\n" +
            "                display: block;\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list .thumbnail:hover {\n" +
            "                border: 1px solid #006efc;\n" +
            "                }\n" +
            "\n" +
            "                .thumbnail-list .link-btn {\n" +
            "                display: inline-block;\n" +
            "                background-color: transparent;\n" +
            "                border: 1px solid #3366cc;\n" +
            "                border-radius: 5px;\n" +
            "                line-height: 20px;\n" +
            "                margin-left: 5px;\n" +
            "                padding: 10px;\n" +
            "                text-align: center;\n" +
            "                text-decoration: none;\n" +
            "                white-space: nowrap;\n" +
            "                font-size: 12px;\n" +
            "                }\n" +
            "\n" +
            "                .sl_anchor {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .slide-status {\n" +
            "                margin-top: 10px;\n" +
            "                }\n" +
            "\n" +
            "                @media only screen and (max-width: 768px) {\n" +
            "                .slide-status {\n" +
            "                padding: 0;\n" +
            "                }\n" +
            "                }\n" +
            "\n" +
            "                .slide-status .current-page {\n" +
            "                display: none;\n" +
            "                margin-right: 6px;\n" +
            "                }\n" +
            "\n" +
            "                .slide-status .sum {\n" +
            "                margin-left: 6px;\n" +
            "                }\n" +
            "\n" +
            "                .slide-status .statistic {\n" +
            "                display: inline-block;\n" +
            "                font-family: Roboto;\n" +
            "                font-size: 12px;\n" +
            "                font-weight: normal;\n" +
            "                font-style: normal;\n" +
            "                font-stretch: normal;\n" +
            "                line-height: normal;\n" +
            "                letter-spacing: normal;\n" +
            "                color: #767676;\n" +
            "                }\n" +
            "\n" +
            "                .slide-status .outer-link {\n" +
            "                float: right;\n" +
            "                color: #006efc;\n" +
            "                font-size: 12px;\n" +
            "                }\n" +
            "\n" +
            "                #slideshow .command {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(1):checked ~ #slideshow .command-group1 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(1):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-0px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(1):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-0vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(1):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(1) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(1):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(1) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(1):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: 0;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(1):checked ~ #slideshow .slide-status .current-page:nth-of-type(1) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(2):checked ~ #slideshow .command-group2 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(2):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-595px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(2):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-100vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(2):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(2) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(2):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(2) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(2):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: 0;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(2):checked ~ #slideshow .slide-status .current-page:nth-of-type(2) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(3):checked ~ #slideshow .command-group3 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(3):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1190px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(3):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-200vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(3):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(3) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(3):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(3) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(3):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: 0;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(3):checked ~ #slideshow .slide-status .current-page:nth-of-type(3) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(4):checked ~ #slideshow .command-group4 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(4):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1785px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(4):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-300vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(4):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(4) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(4):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(4) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(4):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: 0;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(4):checked ~ #slideshow .slide-status .current-page:nth-of-type(4) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(5):checked ~ #slideshow .command-group5 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(5):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2380px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(5):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-400vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(5):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(5) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(5):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(5) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(5):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -40px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(5):checked ~ #slideshow .slide-status .current-page:nth-of-type(5) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(6):checked ~ #slideshow .command-group6 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(6):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2975px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(6):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-500vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(6):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(6) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(6):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(6) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(6):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -120px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(6):checked ~ #slideshow .slide-status .current-page:nth-of-type(6) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(7):checked ~ #slideshow .command-group7 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(7):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-3570px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(7):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-600vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(7):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(7) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(7):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(7) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(7):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -200px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(7):checked ~ #slideshow .slide-status .current-page:nth-of-type(7) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(8):checked ~ #slideshow .command-group8 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(8):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-4165px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(8):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-700vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(8):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(8) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(8):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(8) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(8):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -280px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(8):checked ~ #slideshow .slide-status .current-page:nth-of-type(8) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(9):checked ~ #slideshow .command-group9 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(9):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-4760px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(9):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-800vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(9):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(9) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(9):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(9) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(9):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -360px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(9):checked ~ #slideshow .slide-status .current-page:nth-of-type(9) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(10):checked ~ #slideshow .command-group10 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(10):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-5355px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(10):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-900vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(10):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(10) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(10):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(10) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(10):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -440px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(10):checked ~ #slideshow .slide-status .current-page:nth-of-type(10) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(11):checked ~ #slideshow .command-group11 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(11):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-5950px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(11):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1000vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(11):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(11) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(11):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(11) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(11):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -520px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(11):checked ~ #slideshow .slide-status .current-page:nth-of-type(11) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(12):checked ~ #slideshow .command-group12 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(12):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-6545px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(12):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1100vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(12):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(12) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(12):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(12) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(12):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -600px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(12):checked ~ #slideshow .slide-status .current-page:nth-of-type(12) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(13):checked ~ #slideshow .command-group13 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(13):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-7140px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(13):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1200vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(13):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(13) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(13):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(13) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(13):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -680px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(13):checked ~ #slideshow .slide-status .current-page:nth-of-type(13) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(14):checked ~ #slideshow .command-group14 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(14):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-7735px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(14):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1300vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(14):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(14) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(14):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(14) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(14):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -760px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(14):checked ~ #slideshow .slide-status .current-page:nth-of-type(14) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(15):checked ~ #slideshow .command-group15 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(15):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-8330px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(15):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1400vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(15):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(15) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(15):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(15) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(15):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -840px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(15):checked ~ #slideshow .slide-status .current-page:nth-of-type(15) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(16):checked ~ #slideshow .command-group16 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(16):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-8925px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(16):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1500vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(16):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(16) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(16):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(16) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(16):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -920px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(16):checked ~ #slideshow .slide-status .current-page:nth-of-type(16) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(17):checked ~ #slideshow .command-group17 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(17):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-9520px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(17):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1600vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(17):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(17) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(17):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(17) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(17):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1000px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(17):checked ~ #slideshow .slide-status .current-page:nth-of-type(17) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(18):checked ~ #slideshow .command-group18 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(18):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-10115px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(18):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1700vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(18):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(18) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(18):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(18) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(18):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1080px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(18):checked ~ #slideshow .slide-status .current-page:nth-of-type(18) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(19):checked ~ #slideshow .command-group19 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(19):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-10710px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(19):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1800vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(19):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(19) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(19):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(19) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(19):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1160px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(19):checked ~ #slideshow .slide-status .current-page:nth-of-type(19) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(20):checked ~ #slideshow .command-group20 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(20):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-11305px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(20):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-1900vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(20):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(20) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(20):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(20) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(20):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1240px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(20):checked ~ #slideshow .slide-status .current-page:nth-of-type(20) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(21):checked ~ #slideshow .command-group21 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(21):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-11900px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(21):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2000vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(21):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(21) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(21):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(21) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(21):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1320px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(21):checked ~ #slideshow .slide-status .current-page:nth-of-type(21) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(22):checked ~ #slideshow .command-group22 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(22):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-12495px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(22):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2100vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(22):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(22) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(22):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(22) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(22):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1400px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(22):checked ~ #slideshow .slide-status .current-page:nth-of-type(22) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(23):checked ~ #slideshow .command-group23 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(23):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-13090px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(23):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2200vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(23):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(23) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(23):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(23) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(23):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1480px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(23):checked ~ #slideshow .slide-status .current-page:nth-of-type(23) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(24):checked ~ #slideshow .command-group24 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(24):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-13685px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(24):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2300vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(24):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(24) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(24):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(24) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(24):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1560px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(24):checked ~ #slideshow .slide-status .current-page:nth-of-type(24) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(25):checked ~ #slideshow .command-group25 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(25):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-14280px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(25):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2400vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(25):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(25) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(25):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(25) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(25):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1640px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(25):checked ~ #slideshow .slide-status .current-page:nth-of-type(25) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(26):checked ~ #slideshow .command-group26 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(26):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-14875px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(26):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2500vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(26):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(26) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(26):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(26) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(26):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1720px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(26):checked ~ #slideshow .slide-status .current-page:nth-of-type(26) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(27):checked ~ #slideshow .command-group27 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(27):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-15470px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(27):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2600vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(27):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(27) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(27):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(27) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(27):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1800px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(27):checked ~ #slideshow .slide-status .current-page:nth-of-type(27) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "                    .sl_anchor:nth-of-type(28):checked ~ #slideshow .command-group28 {\n" +
            "                    display: inline-flex;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(28):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-16065px);\n" +
            "                    }\n" +
            "\n" +
            "                    @media only screen and (max-width: 768px) {\n" +
            "                    .sl_anchor:nth-of-type(28):checked ~ #slideshow .slider-placeholder {\n" +
            "                    transform: translateX(-2700vw);\n" +
            "                    }\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(28):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(28) .thumbnail {\n" +
            "                    border: 1px solid #006efc;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(28):checked ~ #slideshow .thumbnail-list .thumbnail-item:nth-of-type(28) .thumbnail .photo-container {\n" +
            "                    margin-top: 7px;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(28):checked ~ #slideshow .thumbnail-list.auto-scroll .thumbnail-list-wrapper {\n" +
            "                    margin-left: \n" +
            "                        -1880px\n" +
            "                    ;\n" +
            "                    }\n" +
            "\n" +
            "                    .sl_anchor:nth-of-type(28):checked ~ #slideshow .slide-status .current-page:nth-of-type(28) {\n" +
            "                    display: inline;\n" +
            "                    }\n" +
            "\n" +
            "                \n" +
            "\n" +
            "                .lg-only, .sm-only, .lg-only-inline, .sm-only-inline {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-blue {\n" +
            "                color: #006efc;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-gray {\n" +
            "                color: #767676;\n" +
            "                }\n" +
            "\n" +
            "                a.cgg-btn {\n" +
            "                border: 1px solid #000;\n" +
            "                box-sizing: border-box;\n" +
            "                font-size: .8rem;\n" +
            "                margin-left: 3px;\n" +
            "                text-align: center;\n" +
            "                text-decoration: none;\n" +
            "                vertical-align: bottom;\n" +
            "                background-color: #fff;\n" +
            "                border-radius: 0;\n" +
            "                display: inline-block;\n" +
            "                max-width: 100%;\n" +
            "                padding: 10px 5px;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-btn__cell {\n" +
            "                color: #000;\n" +
            "                -webkit-box-align: center;\n" +
            "                align-items: center;\n" +
            "                display: -webkit-box;\n" +
            "                display: flex;\n" +
            "                width: 100%;\n" +
            "                -webkit-box-pack: center;\n" +
            "                justify-content: center;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-btn__icon:last-child, .details__icon {\n" +
            "                margin-left: 8px;\n" +
            "                }\n" +
            "\n" +
            "                svg.cgg-btn__icon {\n" +
            "                stroke-width: 0;\n" +
            "                flex-shrink: 0;\n" +
            "                height: 10px;\n" +
            "                width: 9.75px;\n" +
            "                }\n" +
            "\n" +
            "                .details__icon svg, svg.cgg-btn__icon {\n" +
            "                fill: #000;\n" +
            "                stroke: #000;\n" +
            "                }\n" +
            "\n" +
            "                svg:not(:root) {\n" +
            "                overflow: hidden;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-expandable {\n" +
            "                position: relative;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-details {\n" +
            "                -webkit-box-align: center;\n" +
            "                align-items: center;\n" +
            "                -webkit-box-sizing: border-box;\n" +
            "                box-sizing: border-box;\n" +
            "                color: #3665f3;\n" +
            "                cursor: default;\n" +
            "                list-style-position: inside;\n" +
            "                list-style-type: none;\n" +
            "                width: 100%;\n" +
            "                position: absolute;\n" +
            "                left: 0;\n" +
            "                bottom: -30px;\n" +
            "                text-align: center;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-details a {\n" +
            "                text-decoration: none;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-details label {\n" +
            "                cursor: pointer;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-details:hover {\n" +
            "                color: #3665f3;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-details-icon-up, .cgg-details-icon-down {\n" +
            "                margin-left: 8px;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-details-icon-up:not([hidden]), .cgg-details-icon-down:not([hidden]) {\n" +
            "                background-repeat: no-repeat;\n" +
            "                vertical-align: middle;\n" +
            "                background-image: url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB3aWR0aD0iMjEuNiIgaGVpZ2h0PSIxMi41OCIgdmlld0JveD0iMS4zNSA1LjcgMjEuNiAxMi41OCI+PHBhdGggZmlsbD0iIzM2NjVGMyIgZD0iTTEyLjE4NiAxOC4yODVjLS40NTEtLjAwOS0uODA5LS4xNjctMS4wNzUtLjQ0MWwtOS4zMzctOS42YTEuNTI3IDEuNTI3IDAgMCAxLS40MjQtLjk5OXYtLjEwOGMuMDE1LS4zODYuMTY2LS43NDEuNDI0LTEuMDA4LjU2LS41NzMgMS41MjktLjU3IDIuMDgyIDBsOC4yOTQgOC41MyA4LjI5Mi04LjUzMmMuNTU4LS41NyAxLjUyNi0uNTcgMi4wOCAwIC4yNjUuMjcuNDE2LjYyOS40MjggMS4wMXYuMDg3Yy0uMDEyLjM5MS0uMTY1Ljc1LS40MjcgMS4wMmwtOS4zMzMgOS42YTEuNDQzIDEuNDQzIDAgMCAxLTEuMDA0LjQ0MSIvPjwvc3ZnPg==);\n" +
            "                height: 5.2px;\n" +
            "                width: 9px;\n" +
            "                background-size: 9px 5.2px;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-details-icon-up {\n" +
            "                -webkit-transform: rotate(180deg);\n" +
            "                transform: rotate(180deg);\n" +
            "                }\n" +
            "\n" +
            "                .cgg-show-less {\n" +
            "                height: 96px;\n" +
            "                overflow: hidden;\n" +
            "                display: block;\n" +
            "                }\n" +
            "\n" +
            "                #chk_desc ~ div.cgg-show-more,\n" +
            "                #chk_equip ~ div.cgg-show-more,\n" +
            "                #chk_about ~ div.cgg-show-more,\n" +
            "                #chk_term ~ div.cgg-show-more {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                #chk_desc + div label:before,\n" +
            "                #chk_equip + div label:before,\n" +
            "                #chk_about + div label:before,\n" +
            "                #chk_term + div label:before {\n" +
            "                content: 'Show more';\n" +
            "                }\n" +
            "\n" +
            "                #chk_desc:checked + div label:before,\n" +
            "                #chk_equip:checked + div label:before,\n" +
            "                #chk_about:checked + div label:before,\n" +
            "                #chk_term:checked + div label:before {\n" +
            "                content: 'Show less';\n" +
            "                }\n" +
            "\n" +
            "                #chk_desc + .cgg-details .cgg-details-icon-up,\n" +
            "                #chk_equip + .cgg-details .cgg-details-icon-up,\n" +
            "                #chk_about + .cgg-details .cgg-details-icon-up,\n" +
            "                #chk_term + .cgg-details .cgg-details-icon-up {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                #chk_desc:checked + .cgg-details .cgg-details-icon-up,\n" +
            "                #chk_equip:checked + .cgg-details .cgg-details-icon-up,\n" +
            "                #chk_about:checked + .cgg-details .cgg-details-icon-up,\n" +
            "                #chk_term:checked + .cgg-details .cgg-details-icon-up {\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "\n" +
            "                #chk_desc + .cgg-details .cgg-details-icon-down,\n" +
            "                #chk_equip + .cgg-details .cgg-details-icon-down,\n" +
            "                #chk_about + .cgg-details .cgg-details-icon-down,\n" +
            "                #chk_term + .cgg-details .cgg-details-icon-down {\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "\n" +
            "                #chk_desc:checked + .cgg-details .cgg-details-icon-down,\n" +
            "                #chk_equip:checked + .cgg-details .cgg-details-icon-down,\n" +
            "                #chk_about:checked + .cgg-details .cgg-details-icon-down,\n" +
            "                #chk_term:checked + .cgg-details .cgg-details-icon-down {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                #chk_desc:checked ~ div.cgg-show-less,\n" +
            "                #chk_equip:checked ~ div.cgg-show-less,\n" +
            "                #chk_about:checked ~ div.cgg-show-less,\n" +
            "                #chk_term:checked ~ div.cgg-show-less {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                #chk_desc:checked ~ div.cgg-show-more,\n" +
            "                #chk_equip:checked ~ div.cgg-show-more,\n" +
            "                #chk_about:checked ~ div.cgg-show-more,\n" +
            "                #chk_term:checked ~ div.cgg-show-more {\n" +
            "                display: block;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-phone-num {\n" +
            "                text-decoration: none;\n" +
            "                color: #006efc;\n" +
            "                font-weight: bold;\n" +
            "                }\n" +
            "\n" +
            "                .separator {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .mt-10 {\n" +
            "                margin-top: 10px;\n" +
            "                }\n" +
            "\n" +
            "                .mt-20 {\n" +
            "                margin-top: 20px;\n" +
            "                }\n" +
            "\n" +
            "                .mt-40 {\n" +
            "                margin-top: 40px;\n" +
            "                }\n" +
            "\n" +
            "                /* --- MOBILE mode --- */\n" +
            "                @media only screen and (max-width: 768px) {\n" +
            "\n" +
            "                .eb-post-vehicle-title {\n" +
            "                /*border-bottom: none;\n" +
            "                border-top: 1px solid #ccc;*/\n" +
            "                border: none;\n" +
            "                padding-bottom: inherit;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container {\n" +
            "                padding-bottom: 10px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container:first-of-type {\n" +
            "                padding-bottom: 0;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container .content {\n" +
            "                margin: 0;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-logo {\n" +
            "                text-align: center;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-phonetracking {\n" +
            "                margin-top: 15px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-phonenumber {\n" +
            "                margin-top: 10px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-photos {\n" +
            "                margin: 1% 1% 10px 1%;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container .title .heading-line {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-viewallphotos-container {\n" +
            "                margin-top: -20px;\n" +
            "                }\n" +
            "\n" +
            "                .sm-only {\n" +
            "                display: block;\n" +
            "                }\n" +
            "\n" +
            "                .sm-only-inline {\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-show-less.cgg-reverse {\n" +
            "                height: auto;\n" +
            "                overflow: auto;\n" +
            "                }\n" +
            "\n" +
            "                .cgg-details {\n" +
            "                width: 98%;\n" +
            "                text-align: right;\n" +
            "                }\n" +
            "\n" +
            "                .separator {\n" +
            "                display: inherit;\n" +
            "                margin-top: 20px;\n" +
            "                color: #fff;\n" +
            "                }\n" +
            "\n" +
            "                .mobi-no-bottom {\n" +
            "                margin-bottom: 0;\n" +
            "                padding-bottom: 0;\n" +
            "                }\n" +
            "\n" +
            "                }\n" +
            "\n" +
            "                /* --- DESKTOP mode --- */\n" +
            "                @media only screen and (min-width: 768px) {\n" +
            "                .eb-post-container {\n" +
            "                margin-bottom: 10px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-container .title {\n" +
            "                margin: 30px 10px 10px 10px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-logo {\n" +
            "                float: left;\n" +
            "                width: 60%;\n" +
            "                margin-right: 2%;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-phonetracking {\n" +
            "                text-align: center;\n" +
            "                width: 35%;\n" +
            "                float: left;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-photos {\n" +
            "                float: left;\n" +
            "                width: 595px;\n" +
            "                margin-right: 82px;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle {\n" +
            "                float: left;\n" +
            "                width: 35%;\n" +
            "                }\n" +
            "\n" +
            "                .view-all-images {\n" +
            "                display: block !important;\n" +
            "                }\n" +
            "\n" +
            "                #popupGallery {\n" +
            "                visibility: hidden;\n" +
            "                opacity: 0;\n" +
            "                background: rgba(0, 0, 0, 0.3);\n" +
            "                position: fixed;\n" +
            "                }\n" +
            "\n" +
            "                .overlay:target {\n" +
            "                visibility: visible !important;\n" +
            "                opacity: 1 !important;\n" +
            "                }\n" +
            "\n" +
            "                .popup {\n" +
            "                margin: 70px auto;\n" +
            "                padding: 30px 10px 0 10px;\n" +
            "                border-radius: 5px;\n" +
            "                width: 640px;\n" +
            "                }\n" +
            "\n" +
            "                .popup .close {\n" +
            "                display: block;\n" +
            "                }\n" +
            "\n" +
            "                .contact-seller-box .eb-post-storelink {\n" +
            "                display: inline-block;\n" +
            "                margin: 0 30px;\n" +
            "                }\n" +
            "\n" +
            "                .accordion {\n" +
            "                display: table;\n" +
            "                table-layout: fixed;\n" +
            "                border-collapse: separate;\n" +
            "                border-spacing: 10px;\n" +
            "                }\n" +
            "\n" +
            "                .accordion label {\n" +
            "                margin: 0 5px;\n" +
            "                text-align: left;\n" +
            "                cursor: default;\n" +
            "                padding: 0;\n" +
            "                border: none;\n" +
            "                }\n" +
            "\n" +
            "                .accordion label:hover {\n" +
            "                color: #000;\n" +
            "                background-color: #fff;\n" +
            "                }\n" +
            "\n" +
            "                .accordion input:checked + label {\n" +
            "                color: #000;\n" +
            "                background-color: #fff;\n" +
            "                }\n" +
            "\n" +
            "                .accordion div {\n" +
            "                display: table-cell;\n" +
            "                border-right: 1px solid #ccc;\n" +
            "                }\n" +
            "\n" +
            "                .accordion div:last-child {\n" +
            "                border: none;\n" +
            "                }\n" +
            "\n" +
            "                .accordion label:after {\n" +
            "                content: '';\n" +
            "                border: none;\n" +
            "                }\n" +
            "\n" +
            "                .accordion input:checked + label:after {\n" +
            "                content: '';\n" +
            "                }\n" +
            "\n" +
            "                .accordion .accordion__content {\n" +
            "                opacity: 1;\n" +
            "                border: none;\n" +
            "                padding: 0;\n" +
            "                }\n" +
            "\n" +
            "                input[name='panel']:checked ~ .accordion__content {\n" +
            "                padding: 0;\n" +
            "                }\n" +
            "\n" +
            "                .vehicle-options .read-more-target {\n" +
            "                opacity: 0;\n" +
            "                max-height: 0;\n" +
            "                font-size: 0;\n" +
            "                margin: 0 !important;\n" +
            "                transition: all .25s cubic-bezier(0, 1, 0.5, 1);\n" +
            "                }\n" +
            "\n" +
            "                .button-show-more-options {\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "\n" +
            "                .vehicle-options .read-more-dots {\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "\n" +
            "                .contactus-desktop {\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "\n" +
            "                .contactus-mobile {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .call-dealer {\n" +
            "                display: none !important;\n" +
            "                }\n" +
            "\n" +
            "                .read-more-trigger:not(.photo-trigger) {\n" +
            "                display: none;\n" +
            "                }\n" +
            "\n" +
            "                .read-more-dots {\n" +
            "                display: none !important;\n" +
            "                }\n" +
            "\n" +
            "                .read-more-target:not(.photo-target) {\n" +
            "                opacity: 1 !important;\n" +
            "                line-height: 18px !important;\n" +
            "                font-size: inherit !important;\n" +
            "                max-height: 999em !important;\n" +
            "                }\n" +
            "\n" +
            "                .lg-only {\n" +
            "                display: block\n" +
            "                }\n" +
            "\n" +
            "                .lg-only-inline {\n" +
            "                display: inline-block;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-vehicle > div:first-child {\n" +
            "                padding-bottom: 1.5em;\n" +
            "                }\n" +
            "\n" +
            "                .eb-post-overview-container > div:first-child {\n" +
            "                margin-top: 0.9em;\n" +
            "                }\n" +
            "\n" +
            "                .desk-no-bottom {\n" +
            "                margin-bottom: 0;\n" +
            "                padding-bottom: 0;\n" +
            "                }\n" +
            "\n" +
            "                }\n" +
            "\n" +
            "            </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "  <div class=\"eb-post-container\" style=\"overflow: auto;\">\n" +
            "    <div class=\"eb-post-logo\"><img src=\"https://photohosting.azureedge.net/vmp/Dealers/3179/Logos/Logo.jpg?v=5562f4df-508f-40c7-a720-e320f9b2041c\"></div>\n" +
            "    <div class=\"eb-post-phonetracking\">\n" +
            "      <div class=\"eb-post-phonenumber\"><span class=\"lg-only-inline\">818-787-0133</span><a class=\"sm-only-inline\" href=\"tel:818-787-0133\">818-787-0133</a></div>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "  <div class=\"eb-post-separator lg-only\"></div>\n" +
            "  <div class=\"eb-post-container desk-no-bottom\">\n" +
            "    <div class=\"eb-post-photos desk-no-bottom\">\n" +
            "      <div class=\"photo-gallery\"><input class=\"sl_anchor\" name=\"slider\" id=\"sli_1\" checked type=\"radio\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_2\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_3\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_4\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_5\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_6\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_7\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_8\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_9\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_10\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_11\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_12\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_13\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_14\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_15\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_16\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_17\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_18\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_19\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_20\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_21\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_22\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_23\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_24\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_25\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_26\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_27\"><input class=\"sl_anchor\" name=\"slider\" type=\"radio\" id=\"sli_28\"><section id=\"slideshow\"><label class=\"&#xA;                                         command prev command-group1\" for=\"sli_28\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                           command next command-group1\" for=\"sli_2\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command prev command-group2\" for=\"sli_1\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command next command-group2\" for=\"sli_3\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command prev command-group3\" for=\"sli_2\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command next command-group3\" for=\"sli_4\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command prev command-group4\" for=\"sli_3\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command next command-group4\" for=\"sli_5\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command prev command-group5\" for=\"sli_4\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command next command-group5\" for=\"sli_6\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command prev command-group6\" for=\"sli_5\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command next command-group6\" for=\"sli_7\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command prev command-group7\" for=\"sli_6\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command next command-group7\" for=\"sli_8\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command prev command-group8\" for=\"sli_7\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command next command-group8\" for=\"sli_9\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command prev command-group9\" for=\"sli_8\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                            command next command-group9\" for=\"sli_10\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                           command prev command-group10\" for=\"sli_9\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                           command next command-group10\" for=\"sli_11\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group11\" for=\"sli_10\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group11\" for=\"sli_12\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group12\" for=\"sli_11\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group12\" for=\"sli_13\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group13\" for=\"sli_12\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group13\" for=\"sli_14\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group14\" for=\"sli_13\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group14\" for=\"sli_15\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group15\" for=\"sli_14\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group15\" for=\"sli_16\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group16\" for=\"sli_15\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group16\" for=\"sli_17\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group17\" for=\"sli_16\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group17\" for=\"sli_18\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group18\" for=\"sli_17\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group18\" for=\"sli_19\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group19\" for=\"sli_18\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group19\" for=\"sli_20\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group20\" for=\"sli_19\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group20\" for=\"sli_21\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group21\" for=\"sli_20\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group21\" for=\"sli_22\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group22\" for=\"sli_21\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group22\" for=\"sli_23\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group23\" for=\"sli_22\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group23\" for=\"sli_24\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group24\" for=\"sli_23\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group24\" for=\"sli_25\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group25\" for=\"sli_24\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group25\" for=\"sli_26\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group26\" for=\"sli_25\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group26\" for=\"sli_27\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group27\" for=\"sli_26\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group27\" for=\"sli_28\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command prev command-group28\" for=\"sli_27\"><div class=\"command-icon\"></div></label><label class=\"&#xA;                                          command next command-group28\" for=\"sli_1\"><div class=\"command-icon\"></div></label><div class=\"container\">\n" +
            "            <div class=\"slider-placeholder\">\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-1.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-2.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-3.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-4.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-5.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-6.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-7.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-8.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-9.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-10.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-11.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-12.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-13.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-14.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-15.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-16.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-17.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-18.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-19.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-20.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-21.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-22.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-23.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-24.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-25.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-26.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-27.jpg\"></div>\n" +
            "              <div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-28.jpg\"></div>\n" +
            "            </div>\n" +
            "          </div>\n" +
            "          <div class=\"slide-status\">\n" +
            "            <div class=\"statistic\"><span class=\"current-page\">1</span><span class=\"current-page\">2</span><span class=\"current-page\">3</span><span class=\"current-page\">4</span><span class=\"current-page\">5</span><span class=\"current-page\">6</span><span class=\"current-page\">7</span><span class=\"current-page\">8</span><span class=\"current-page\">9</span><span class=\"current-page\">10</span><span class=\"current-page\">11</span><span class=\"current-page\">12</span><span class=\"current-page\">13</span><span class=\"current-page\">14</span><span class=\"current-page\">15</span><span class=\"current-page\">16</span><span class=\"current-page\">17</span><span class=\"current-page\">18</span><span class=\"current-page\">19</span><span class=\"current-page\">20</span><span class=\"current-page\">21</span><span class=\"current-page\">22</span><span class=\"current-page\">23</span><span class=\"current-page\">24</span><span class=\"current-page\">25</span><span class=\"current-page\">26</span><span class=\"current-page\">27</span><span class=\"current-page\">28</span><span>of</span><span class=\"sum\">28</span></div>\n" +
            "          </div>\n" +
            "          <div class=\"thumbnail-list\">\n" +
            "            <div class=\"thumbnail-list-wrapper\">\n" +
            "              <div class=\"thumbnail-item\"><label class=\"thumbnail\" for=\"sli_1\"><div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-1.jpg\"></div></label></div>\n" +
            "              <div class=\"thumbnail-item\"><label class=\"thumbnail\" for=\"sli_2\"><div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-2.jpg\"></div></label></div>\n" +
            "              <div class=\"thumbnail-item\"><label class=\"thumbnail\" for=\"sli_3\"><div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-3.jpg\"></div></label></div>\n" +
            "              <div class=\"thumbnail-item\"><label class=\"thumbnail\" for=\"sli_4\"><div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-4.jpg\"></div></label></div>\n" +
            "              <div class=\"thumbnail-item\"><label class=\"thumbnail\" for=\"sli_5\"><div class=\"photo-container\"><img src=\"https://vehicle-photos-published.vauto.com/19/ad/78/30-d8b6-4fb3-958e-e1d29b11c3bc/image-5.jpg\"></div></label></div><a class=\"cgg-btn\" href=\"https://vmp.ebay.com/ebay/viewAllPhotos.aspx?smid=64560\"><span class=\"cgg-btn__cell\"><span>Full size photos</span><svg aria-hidden=\"true\" class=\"cgg-btn__icon\" focusable=\"false\"><use href=\"#icon-arrow-right-bold\"></use></svg></span></a></div>\n" +
            "          </div></section></div>\n" +
            "      <div class=\"eb-post-viewallphotos-container sm-only\"><a class=\"cgg-btn\" href=\"https://vmp.ebay.com/ebay/viewAllPhotos.aspx?smid=64560\"><span class=\"cgg-btn__cell\"><span>Full size photos</span><svg aria-hidden=\"true\" class=\"cgg-btn__icon\" focusable=\"false\"><use href=\"#icon-arrow-right-bold\"></use></svg></span></a></div>\n" +
            "    </div>\n" +
            "    <hr class=\"separator\">\n" +
            "    <div class=\"eb-post-vehicle\">\n" +
            "      <div class=\"eb-post-vehicle-title\"><span>2022 Ford Mustang Mach 1</span></div>\n" +
            "      <div class=\"eb-post-overview-container\">\n" +
            "        <div class=\"eb-post-vehicle-overview\">\n" +
            "          <div class=\"overview-title\">Stock #:\n" +
            "                                    </div>\n" +
            "          <div class=\"overview-value\">IRV-001</div>\n" +
            "        </div>\n" +
            "        <div class=\"eb-post-vehicle-overview\">\n" +
            "          <div class=\"overview-title\">Exterior Color:\n" +
            "                                    </div>\n" +
            "          <div class=\"overview-value\">Oxford White</div>\n" +
            "        </div>\n" +
            "        <div class=\"eb-post-vehicle-overview\">\n" +
            "          <div class=\"overview-title\">Interior Color:\n" +
            "                                    </div>\n" +
            "          <div class=\"overview-value\">Ebony</div>\n" +
            "        </div>\n" +
            "        <div class=\"eb-post-vehicle-overview\">\n" +
            "          <div class=\"overview-title\">Body Type:\n" +
            "                                    </div>\n" +
            "          <div class=\"overview-value\">2D Coupe</div>\n" +
            "        </div>\n" +
            "        <div class=\"eb-post-vehicle-overview\">\n" +
            "          <div class=\"overview-title\">Transmission:\n" +
            "                                    </div>\n" +
            "          <div class=\"overview-value\">Tremec 6-Speed Manual</div>\n" +
            "        </div>\n" +
            "        <div class=\"eb-post-vehicle-overview\">\n" +
            "          <div class=\"overview-title\">Drivetrain:\n" +
            "                                    </div>\n" +
            "          <div class=\"overview-value\">RWD</div>\n" +
            "        </div>\n" +
            "        <div class=\"eb-post-vehicle-overview\">\n" +
            "          <div class=\"overview-title\">Engine:\n" +
            "                                    </div>\n" +
            "          <div class=\"overview-value\">5.0L V8 Ti-VCT</div>\n" +
            "        </div>\n" +
            "        <div class=\"eb-post-vehicle-overview\">\n" +
            "          <div class=\"overview-title\">Mileage:\n" +
            "                                    </div>\n" +
            "          <div class=\"overview-value\">690</div>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "      <div class=\"clear-both\"></div>\n" +
            "    </div>\n" +
            "    <div class=\"clear-both\"></div>\n" +
            "  </div>\n" +
            "  <div class=\"eb-post-separator sm-only\"></div>\n" +
            "  <div vocab=\"https://schema.org/\" typeof=\"Product\" style=\"display: none;\"><span property=\"description\">THE DESCRIPTION HAS CHANGED</span></div>\n" +
            "  <div class=\"eb-post-container\" id=\"div_vehicle_description\">\n" +
            "    <div class=\"title\">\n" +
            "      <h2>Vehicle Description</h2><span class=\"heading-line\"></span></div>\n" +
            "    <div class=\"content\">\n" +
            "      <div class=\"equipment-list\">THE DESCRIPTION HAS CHANGED</div>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "  <div class=\"eb-post-separator sm-only\"></div>\n" +
            "  <div class=\"eb-post-container\">\n" +
            "    <div class=\"title\">\n" +
            "      <h2>Vehicle Warranty</h2><span class=\"heading-line\"></span></div>\n" +
            "    <div class=\"content\">\n" +
            "        <p>\n" +
            "        Most new vehicles come with a factory warranty and some used vehicles have a remaining factory warranty. Please contact us for the warranty vehicles specific to this vehicle.</p>\n" +
            "      </div>\n" +
            "  </div>\n" +
            "  <div class=\"eb-post-separator sm-only\"></div>\n" +
            "  <div class=\"eb-post-container\">\n" +
            "    <div class=\"title\">\n" +
            "      <h2>\n" +
            "                        About FN-QA-IRVINEMOTORS</h2><span class=\"heading-line\"></span></div>\n" +
            "    <div class=\"content\"><p>\n" +
            "    <span style=\"font-size: 22px;\"><span style=\"color: rgb(255, 0, 0);\"><strong>&nbsp;This is a test please do not bid.</strong></span></span></p>\n" +
            "<div>\n" +
            "    &nbsp;</div>\n" +
            "<div>\n" +
            "    &nbsp;</div>\n" +
            "<div>\n" +
            "    Lorem iipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo liasgula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,</div>\n" +
            "<div>\n" +
            "    Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc. Testing.</div>\n" +
            "<div class=\"mt-10\">\n" +
            "        <div class=\"contact-seller-box\">\n" +
            "          <div><strong class=\"cgg-gray\">Contact us for more details</strong></div>\n" +
            "          <div style=\"margin: 10px 0;\"><span class=\"cgg-phone-num lg-only-inline\">818-787-0133</span><a class=\"cgg-phone-num sm-only-inline\" href=\"tel:818-787-0133\">818-787-0133</a></div>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "  <div class=\"eb-post-separator sm-only\"></div>\n" +
            "  <div class=\"eb-post-container mobi-no-bottom\">\n" +
            "    <div class=\"title\">\n" +
            "      <h2>Terms and Conditions</h2><span class=\"heading-line\"></span></div>\n" +
            "    <div class=\"content\">\n" +
            "      <div><b>Payment Options</b></div>\n" +
            "      <div class=\"border-bottom\">\n" +
            "                                    We accept the following payment methods:\n" +
            "                                    <br><span>- Cashier's Check/money order</span><br></div>\n" +
            "      <div><b>Vehicle Pickup & Shipping</b></div>\n" +
            "      <div class=\"border-bottom\">\n" +
            "                    All shipping charges are buyer's responsibility.\n" +
            "                  </div>\n" +
            "      <div class=\"lg-only\"><b>\n" +
            "                                        Finance, Warranty, Shipping question?\n" +
            "                                    </b><br><div class=\"border-bottom\">\n" +
            "                                        Call the dealer at 818-787-0133</div>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "  <div class=\"eb-post-container\">\n" +
            "    <div class=\"title\">\n" +
            "      <h2>General Terms</h2><span class=\"heading-line\"></span></div>\n" +
            "    <div class=\"content\"><p>\n" +
            "    Notice to Bidders: The vehicles we list for sale at eBay are also for sale at our retail location. Please contact us to confirm vehicle availability.<br />\n" +
            "    <br />\n" +
            "    We reserve the right to end an auction early. Deposit: We require a non-refundable $500 deposit within 48 hours of winning the auction. Please call to make arrangements for payment. We accept the following forms of payment: Cash in person, certified funds, institutional financing. All sales transactions must be completed within 7 calendar days of auction close.<br />\n" +
            "    <br />\n" +
            "    Prices are subject to change without notice. Although every effort is made to present accurate and reliable vehicle information, use of this information is voluntary, and should only be deemed reliable after an independent review of its accuracy, completeness, and timeliness. It is the sole responsibility of the customer to verify the existence of options, accessories and the vehicle condition before time of sale. Any and all differences must be addressed prior to time of sale. No expressed or implied warranties, including the availability or condition of the equipment listed is made. EPA mileage estimates are for comparison purposes only. Actual mileage may vary depending on driving conditions, driving habits, and vehicle maintenance.</p></div>\n" +
            "  </div>\n" +
            "  <div class=\"eb-post-container\">\n" +
            "    <div class=\"title\">\n" +
            "      <h2>Fees and Taxes</h2><span class=\"heading-line\"></span></div>\n" +
            "    <div class=\"content\"><p>\n" +
            "    State or local taxes, title, license fee, processing fees, registration fee, dealer documentary fee, finance charges, emission testing fees, and compliance fees are additional to the advertised price.</p></div>\n" +
            "  </div>\n" +
            "</body>";

    private final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><description></description></xml>";
    public static void main(String... args) {
        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build(new StringReader(xml));
            Element root = document.getRootElement();
            Element comments = root.getChild("comments");

            Element comment = comments.getChild("comment");

            // Using the setContent and addContent to add CDATA section
            // into  the xml element.
            comment.setContent(
                    new CDATA("<b>This is a bold string</b>."));
            comment.addContent(
                    new CDATA("<i>And this an italic string</i>."));

            XMLOutputter outputter =
                    new XMLOutputter(Format.getPrettyFormat());
            outputter.output(document, System.out);

            // Reading a CDATA section is simply done by calling the
            // getText method. It doesn't care if it was a simple string
            // or a CDATA section, it will just return the content as
            // string.
            String text = comment.getText();
            System.out.println("Text = " + text);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }
}

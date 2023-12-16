# Microsoft Graph Commons module for Mendix

This module is an extension to the [Microsoft Graph Connector](https://github.com/swkruger/Mendix-MSGraphConnector) module which serves as a connector module on a rather abstract level. This module therefore provides convenient to use import and export mappings as well as plug-and-play microflows for some of the mostly used operations of the Microsoft Graph API.

## Typical usage scenario

For Mendix developers seeking to enhance their Mendix applications with automated operations in Microsoft products (Azure, Outlook, Teams, ...), the Mendix connector for Microsoft Graph offers a valuable solution. Note that his extension covers only covers some of the operations of the Micsrosoft Graph API. However, you can always fall back on the Microsoft Graph Connector module and make you own personalized requests using the generic microflows provided there.

## Features

- Send mails
- Get organization users
- Create Outlook events
- ...

## Preparation

For preparation instructions visit the [Github repository of the Microsoft Graph Connector module](https://github.com/swkruger/Mendix-MSGraphConnector#installation--configuration). This module does not require any preparation besides the one of the Microsoft Graph Connector module.

## Installation

1. Install the Dependencies from the Mendix Marketplace:
   - [Microsoft Graph Connector](https://marketplace.mendix.com/link/component/117007)
3. Follow the [installation instructions of the Microsoft Graph Connector module](https://github.com/swkruger/Mendix-MSGraphConnector#installation--configuration)
4. Install the [Microsoft Graph Commons](https://marketplace.mendix.com/link/component/219754) from the Mendix Marketplace
5. Assign the module roles to your projects user roles. Users can use the microflows provided in the USE_ME folder.

## Configuration

For configuration instructions visit the [Github repository of the Microsoft Graph Connector module](https://github.com/swkruger/Mendix-MSGraphConnector#installation--configuration). This module does not require any configuration besides the one of the Adobe Sign Connector module.

## Usage

After [preparation](#preparation), [installation](#installation) and [configuration](#configuration) you can now use the micrflows from the USE_ME package of the Microsoft Graph Commons module by passing the required parameters to it.

## Help improving this module

I built this module based on my own usage of the Microsoft Graph API. Please let me know if you are missing any commonly used operations of the API so I can consider adding them in a later version.

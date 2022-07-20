
    //added filestack to upload organizations photos
    const button = document.querySelector('.upload')
    const image = document.querySelector('.donorPic')
    button.addEventListener('click', () => {
    const apiKey = 'AzWevRAKVQki1Rm9iW9CRz'
    const client = filestack.init(apiKey)
    const options = {
    accept: ['image/*'],
    onUploadDone: (uploadResponse) => {
    console.log("onUploadDone", uploadResponse);
    image.setAttribute('src', uploadResponse.filesUploaded[0].url)
},
};
    client.picker(options).open();
});



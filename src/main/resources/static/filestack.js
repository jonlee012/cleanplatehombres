//
//     //added filestack to upload organizations photos
//     const button = document.querySelector('.upload')
//     const image = document.querySelector('.donorPic')
//     button.addEventListener('click', () => {
//     // const apiKey = 'AzWevRAKVQki1Rm9iW9CRz'
//     const client = filestack.init(FSapiKey)
//     const options = {
//     accept: ['image/*'],
//     onUploadDone: (uploadResponse) => {
//     console.log("onUploadDone", uploadResponse);
//     image.setAttribute('src', uploadResponse.filesUploaded[0].url)
// },
// };
//     client.picker(options).open();
// });
// const token = "pk.eyJ1Ijoiamhjb25nZXIiLCJhIjoiY2t5eGhicmV3MGlqZjJ1bXc1MXdzMnlubSJ9.53Uuao-kj-NGMyyhFNJTMA"
// const weathertoken = "6450ed6396197087c7e503f463ddc13e"
// const FSAPI = "A4TFVB6yBQSiutacj1pDnz"

// const client = filestack.init(FSapiKey);
// const options = {
//     fromSources: ['local_file_system'],
//     transformations: {
//         crop: true,
//         circle: true,
//         rotate: true
//     }
// }
// const picker = client.picker({
//     exposeOriginalFile: true,
//     onFileSelected: checkImgSize,
// });
// function openPhotoPicker() {
//     console.log("open Photo Picker");
//     client.pick({
//         accept: 'image/*',
//         maxFiles: 1,
//     }).then(function (result) {
//         console.log(JSON.stringify(result));
//         imageHandle = result.filesUploaded[0].url;
//         console.log(imageHandle);
//     }).then(function () {
//         $(".organizationImages").append("<input type='hidden' name='imageUrl' value='" + imageHandle + "'>");
//     })
//     json_data = {imageHandle}
//     var organizationImages = document.createElement("img");
//     organizationImages.onload = function () {
//         document.getElementById("organizationImages").appendChild(organizationImages);
//     }
//
//     organizationImages.src = imageHandle;
//     function checkImgSize (file) {
//         return new Promise(function (resolve, reject) {
//             const maxWidth = 300;
//             const maxHeight = 300;
//             const blob = file.originalFile;
//
//             // Get an object URL for the local file
//             const url = URL.createObjectURL(blob);
//
//             // Create an image and load the object URL
//             const img = new Image();
//             img.src = url;
//
//             img.onload = function () {
//                 URL.revokeObjectURL(url);
//
//                 if (this.naturalWidth > maxWidth) {
//                     reject('File is too wide');
//                 }
//
//                 if (this.naturalHeight > maxHeight) {
//                     reject('File is too tall');
//                 }
//
//                 // If we made it here then the file was approved
//                 resolve();
//             }
//         });
//     }
//
//
// }


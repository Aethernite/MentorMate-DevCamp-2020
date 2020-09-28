import React from 'react';
import { useDispatch } from 'react-redux';
import styled from 'styled-components';
import { uploadFile } from '../../../store/slices/upload';


const StyledButton = styled.button`
color: #6b6a6a;
cursor: pointer;
margin: 0px;
margin-top: 1rem;
`;

const Icon = styled.i`
 font-size: 20px;
 display: inline-block;
`;


const PostFileUploadButton = () => {
    const hiddenFileInput = React.useRef(null);
    const dispatch = useDispatch();

    const handleClick = () => {
        hiddenFileInput.current.click();
    };

    const handleChange = event => {
        const fileUploaded = event.target.files[0];
        handleFile(fileUploaded);
    };

    const handleFile = async (file) => {
        dispatch(uploadFile(file));
    }

    return (
        <div>
            <StyledButton type="button" onClick={handleClick} className="btn w-100"><Icon className="fa fa-camera"></Icon></StyledButton>
            <input
                type="file"
                accept="image/*"
                ref={hiddenFileInput}
                onChange={handleChange}
                style={{ display: 'none' }}
            />
        </div>
    );
}
export default PostFileUploadButton;